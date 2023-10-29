import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] minDistance;
    static int result = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minDistance = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(minDistance[i], 987654321);
            graph.add(new ArrayList<>());
            minDistance[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            minDistance[a][b] = c;
            minDistance[b][a] = c;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    minDistance[j][k] = Math.min(minDistance[j][k], minDistance[j][i] + minDistance[i][k]);
                }
            }
        }

        int minSum = 987654321;
        for(int i = 1; i <= N; i++){
            int sum = 0;

            for (int j = 1; j <= N; j++) {
                sum += minDistance[i][j];
            }

            if(sum < minSum) {
                result = i;
                minSum = sum;
            }
        }

        System.out.println(result);
    }
}
