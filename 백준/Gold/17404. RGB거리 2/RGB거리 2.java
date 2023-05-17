import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, result = 987654321;
    static int[][] info;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        info = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++)
                info[i][j] = Integer.parseInt(st.nextToken());

        }

        dp[0][0] = info[0][0];
        dp[0][1] = dp[0][2] = 987654321;

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + info[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + info[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + info[i][2];
        }

        result = Math.min(result, Math.min(dp[N - 1][1], dp[N - 1][2]));

        dp[0][1] = info[0][1];
        dp[0][0] = dp[0][2] = 987654321;

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + info[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + info[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + info[i][2];
        }

        result = Math.min(result, Math.min(dp[N - 1][0], dp[N - 1][2]));

        dp[0][2] = info[0][2];
        dp[0][0] = dp[0][1] = 987654321;

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + info[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + info[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + info[i][2];
        }

        result = Math.min(result, Math.min(dp[N - 1][0], dp[N - 1][1]));

        System.out.println(result);
    }
}