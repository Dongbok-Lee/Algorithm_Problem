
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] floyd;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        floyd = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= N; j++) {
                floyd[i][j] = str.charAt(j - 1) == 'N' ? 987654321 : 1;
            }

            floyd[i][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    floyd[j][k] = Math.min(floyd[j][k], floyd[j][i] + floyd[i][k]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int friends = 0;
            for (int j = 1; j <= N; j++) {
                if(floyd[i][j] <= 2) {
                    friends++;
                }
            }
            result = Math.max(result, friends);
        }
        System.out.println(result - 1);
    }
}