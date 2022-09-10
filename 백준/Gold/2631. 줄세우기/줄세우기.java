import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int[] arr = new int[201];
    static int[] dp = new int[201];
    static int N, max = 1;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < N; i++)
            dp[i] = 1;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(arr[i] < arr[j]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                    max = Math.max(max, dp[j]);
                }
            }
        }
        System.out.println(N-max);
    }
}
