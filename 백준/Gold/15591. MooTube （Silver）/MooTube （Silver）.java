import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<Node>> graph;
    private static int N, Q;


    public static void main(String[] args) throws IOException{


        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(bfs(k, v)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int dist, int node) {
        int result = 0;
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[node] = true;
        q.offer(new Node(node, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(Node next : graph.get(cur.idx)) {
                if(!visited[next.idx] && next.dist >= dist) {
                    result++;
                    visited[cur.idx] = true;
                    q.offer(next);
                }
            }
        }

        return result;
    }
}