import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] map = new char[10000][500];
    static boolean[][] visited = new boolean[10000][500];
    static StringTokenizer st;
    static int count = 0;
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < R; i++){
            String arr = br.readLine();
            for(int j = 0; j < C; j++)
                map[i][j] = arr.charAt(j);
        }

        for(int i = 0; i < R; i++){
            dfs(i,0);
        }

        System.out.println(count);
    }

    static boolean dfs(int x, int y){
/*
        System.out.println();
        for(int i = 0; i < R; i++){
            System.out.println();
            for(int j = 0; j < C; j++)
                System.out.print(visited[i][j]);
        }
*/

        if(y == C -1){
            count++;
            return true;
        }

        for(int i = 0; i < 3; i++){
            int nextX = x + dx[i];
            if(isInside(nextX) && visited[nextX][y+1] == false && map[nextX][y+1] != 'x'){
                visited[nextX][y+1] = true;
                if(dfs(nextX, y+1))
                    return true;
            }
        }
        return false;
    }

    static boolean isInside(int x){
        if(x < 0 || x >= R)
            return false;
        return true;
    }

}