import java.io.*;
import java.util.*;
import java.math.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M, N;
    static int[][] map = new int[501][501];
    static int[][] dp = new int[501][501];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                dp[i][j] = -1;

        writer.write(DFS(0, 0) + "\n");
        writer.flush();
        writer.close();
        reader.close();

    }

    public static int DFS(int x, int y){
        if(x == M-1 && y == N-1)
            return 1;

        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(!isInside(nextX,nextY))
                continue;

            if(map[x][y] > map[nextX][nextY])
                dp[x][y] += DFS(nextX, nextY);
        }

        return dp[x][y];
    }

    static boolean isInside(int x, int y){
        if(x < 0 || y < 0 || x >= M || y >= N)
            return false;
        return true;
    }
}
