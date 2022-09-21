import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N, K;
    static int[] dp = new int[100001];
    static int[] coinArr = new int[101];

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();
        K = sc.nextInt();
        for(int i = 0; i <= K; i++)
            dp[i] = 1987654321;
        for(int i = 0; i < N; i++){
            int coin = sc.nextInt();
            coinArr[i] = coin;
            dp[coin] = 1;
        }

        Arrays.sort(coinArr,0,N);


        for(int i = 1; i <= K; i++){
            for(int j = 0; j < N; j++){
                if(i <= coinArr[j])
                    break;
                dp[i] = Math.min(dp[i-coinArr[j]]+1,dp[i]);
            }
        }
        if(dp[K] == 1987654321 )
            System.out.println(-1);
        else
            System.out.println(dp[K]);
    }

}
