import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int max = 0;
    static int[] arr = new int[1001];
    static int[] dp = new int[1001];


    public static void main(String[] args) throws Exception {
        N = sc.nextInt();

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 1; i < N; i++)
            for(int j = 0; j < i; j++)
                    if(dp[i] <= dp[j] && arr[i] > arr[j])
                        dp[i] = dp[j] + 1;

        for(int i = 0; i < N; i++)
            max = Math.max(dp[i], max);



        System.out.println(max + 1);

    }
}


