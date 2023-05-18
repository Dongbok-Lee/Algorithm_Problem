import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Edge> graph;
    static final int INF = 987654321;
    static int N, M;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Edge(v, w, cost));
        }

        bellmanFord(1);
    }

    static void bellmanFord(int start){
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Edge edge = graph.get(j);

                if(dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost){
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for(int i = 0; i < M; i++){
            Edge edge = graph.get(i);

            if(dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost){
                System.out.println(-1);
                return;
            }
        }



        for(int i = 2; i <= N; i++){
            if(dist[i] == INF)
                System.out.println(-1);
            else
                System.out.println(dist[i]);
        }
    }

    static class Edge{
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
}