import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] board = new int[101][101];
    static long[][] dp = new long[101][101];
    static boolean[][] visited = new boolean[101][101];
    static Queue<Location> q = new LinkedList<>();


    public static void main(String[] args) throws Exception {

        N = sc.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        q.offer(new Location(0,0));
        dp[0][0] = 1;

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
                if(i == N-1 && j == N-1)
                    break;

                int size = board[i][j];
                if(isInside(i,j+size))
                    dp[i][j+size] += dp[i][j];
                if(isInside(i+size, j))
                    dp[i+size][j] += dp[i][j];
            }

        System.out.println(dp[N-1][N-1]);
    }

    static boolean isInside(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;

        return true;
    }

}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
