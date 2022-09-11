import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static long[][][] dp = new long[101][101][101];
    static int N, L, R;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        dp[1][1][1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i][1][i] = dp[i][i][1] = 1;
            for(int j = 1; j <= L; j++){
                for(int k = 1; k <= R; k++){
                    dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + (dp[i-1][j][k] * (i-2))) % 1000000007;
                }
            }
        }

        System.out.println(dp[N][L][R]);
    }
}