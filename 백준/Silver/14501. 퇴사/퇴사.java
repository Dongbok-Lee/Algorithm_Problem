import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] T = new int[16];
    static int[] P = new int[16];
    static int[] dp = new int[21];
    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for(int i = N; i > 0; i--){
            if(i+T[i]-1 <= N)
                dp[i] = Math.max(dp[i+1],dp[i+T[i]] + P[i]);
            else
                dp[i] = dp[i+1];
        }
        System.out.println(dp[1]);

    }
}
