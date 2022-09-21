import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] dp = new int[100001];

    public static void main(String[] args) throws Exception {

        N = sc.nextInt();
        dp[1] = 3;
        dp[2] = 7;

        for(int i = 3; i <= N; i++)
            dp[i] = (dp[i-2]*3 + (dp[i-1]-dp[i-2]) * 2) % 9901;

        System.out.println(dp[N]);
    }
}