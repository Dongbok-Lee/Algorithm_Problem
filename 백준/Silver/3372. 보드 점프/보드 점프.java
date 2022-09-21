import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] board = new int[101][101];
    static BigInteger[][] dp = new BigInteger[101][101];


    public static void main(String[] args) throws Exception {

        N = sc.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();


        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                dp[i][j] = BigInteger.ZERO;

        dp[0][0] = BigInteger.valueOf(1);

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
                if(i == N-1 && j == N-1)
                    break;

                int size = board[i][j];

                if(isInside(i,j+size))
                    dp[i][j+size] = dp[i][j].add(dp[i][j + size]);
                if(isInside(i+size, j))
                    dp[i+size][j] = dp[i+size][j].add(dp[i][j]);
            }

        System.out.println(dp[N-1][N-1]);
    }

    static boolean isInside(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;

        return true;
    }

}
