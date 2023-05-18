import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] arr;
    static ArrayList<Edge> graph;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        arr = new int[N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[w]++;
            graph.add(new Edge(v, w, cost));
        }

        int result = 0;
        for(int i = 1; i <= N; i++)
            if(arr[i] == 0)
                result = Math.max(bellmanFord(i), result);

        System.out.println(result);
    }

    static int bellmanFord(int start){
        int[] dist = new int[N + 1];


        Arrays.fill(dist, -1);
        dist[start] = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Edge cur = graph.get(j);

                if(dist[cur.v] != -1 && dist[cur.v] +  cur.cost > dist[cur.w]){
                    dist[cur.w] = dist[cur.v] + cur.cost;
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= N; i++)
            result = Math.max(dist[i], result);

        return result;
    }

    static class Edge{
        int v, w, cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
}