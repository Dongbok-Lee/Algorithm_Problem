import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N, vipN;
    static boolean[] vip = new boolean[41];
    static long[] dp = new long[41];

    public static void main(String[] args) throws Exception {

        N = sc.nextInt();
        vipN = sc.nextInt();
        for(int i = 0; i < vipN; i++)
            vip[sc.nextInt()] = true;

        vip[0] = true; dp[0] = 1; dp[1] = 1;

        for(int i = 2; i <= N; i++){
            if(vip[i] == true || vip[i-1] == true)
                dp[i] = dp[i-1];
            else if(vip[i-2] == true)
                dp[i] = dp[i-2] * 2;
            else
                dp[i] = dp[i-2] * 2 + dp[i-3];
        }

        System.out.println(dp[N]);
    }
}


