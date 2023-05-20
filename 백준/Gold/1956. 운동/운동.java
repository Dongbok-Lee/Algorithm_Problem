import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static int V, E;
    static final int INF = 1987654321;


    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];

        for(int i = 0; i < V + 1; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for(int i = 0; i <= V; i++){
            for(int j = 0; j <= V; j++){
                for(int k = 0; k <= V; k++){
                    if(graph[i][j] != INF){
                        graph[i][k] = Math.min(graph[i][k], graph[i][j] + graph[j][k]);
                    }
                }
            }
        }

        int result = INF;

        for(int i = 0; i <= V; i++){
            result = Math.min(graph[i][i], result);
            
        }
        
        if(result == INF)
            result = -1;
        System.out.println(result);
    }
}