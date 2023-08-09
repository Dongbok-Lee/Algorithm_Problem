import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    static int[] number;
    static int N;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        dp = new int[N  + 1];
        number = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            int max = 0;
            int min = 987654321;

            for (int j = i; j > 0; j--) {
                min = Math.min(min, number[j]);
                max = Math.max(max, number[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + (max - min));
            }
        }

        System.out.println(dp[N]);

    }
}
