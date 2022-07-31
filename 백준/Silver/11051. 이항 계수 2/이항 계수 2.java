import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[][] dp = new int[1001][1001];

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i <= N; i++)
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%10007;
            }

        System.out.println(dp[N][K]);

    }
}
