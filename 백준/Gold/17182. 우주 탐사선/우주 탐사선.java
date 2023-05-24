import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, result = 1987654321;
    static int[][] planet;
    static int[][] minPlanetDistance;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        planet = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    planet[i][k] = Math.min(planet[i][k], planet[i][j] + planet[j][k]);
                }
            }
        }

        dfs(K, 0);

        System.out.println(result);


    }

    static void dfs(int planetNum, int distance){

        visited[planetNum] = true;

        if(isAllVisited()){
            result = Math.min(result, distance);
        }

        for(int i  = 0; i < N; i++){
            if(!visited[i]){
               dfs(i, distance + planet[planetNum][i]);
            }
        }

        visited[planetNum] = false;
    }

    static boolean isAllVisited(){
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }
}