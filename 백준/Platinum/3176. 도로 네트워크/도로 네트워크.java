import java.io.*;
import java.util.*;


class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static ArrayList<ArrayList<Node>> graph;
    static int[][] parent, minDist, maxDist;
    static int[] depth;
    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        depth = new int[100001];
        parent = new int[100001][18];
        minDist = new int[100001][18];
        maxDist = new int[100001][18];

        Arrays.fill(depth, -1);
        depth[0] = 0;

        for(int i = 0; i <= N; i++){
            Arrays.fill(parent[i], -1);
            Arrays.fill(maxDist[i], 1000001);
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            int A, B, C;

            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        K = Integer.parseInt(br.readLine());

        depth[1] = 1;
        dfs(1);

        for(int j = 0; j < 18; j++){
            for(int i = 1; i <= N; i++){
                if(parent[i][j] != -1){
                    parent[i][j + 1] = parent[parent[i][j]][j];
                    minDist[i][j + 1] = Math.min(minDist[parent[i][j]][j], minDist[i][j]);
                    maxDist[i][j + 1] = Math.max(maxDist[parent[i][j]][j], maxDist[i][j]);
                }
            }
        }

        while(K-- != 0){

            int minResult = 1000001, maxResult = 0;

            int D, E;

            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if(depth[D] < depth[E]){
                int tmp = D;
                D = E;
                E = tmp;
            }

            int diff = depth[D] - depth[E];

            for(int k = 0; diff != 0; k++){
                if(diff % 2 != 0){
                    maxResult = Math.max(maxDist[D][k], maxResult);
                    minResult = Math.min(minDist[D][k], minResult);
                    D = parent[D][k];
                }

                diff /= 2;
            }

            if(D != E){
                for(int j = 17; j >= 0; j--){
                    if(parent[D][j] != -1 && parent[D][j] != parent[E][j]){
                        minResult = Math.min(Math.min(minDist[D][j], minDist[E][j]), minResult);
                        maxResult = Math.max(Math.max(maxDist[D][j], maxDist[E][j]), maxResult);
                        D = parent[D][j];
                        E = parent[E][j];
                    }
                }

                minResult = Math.min(Math.min(minDist[D][0], minDist[E][0]), minResult);
                maxResult = Math.max(Math.max(maxDist[D][0], maxDist[E][0]),maxResult);
            }

            sb.append(minResult + " " + maxResult);
            if(K != 0)
                sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    static void dfs(int cur){
        for(Node next : graph.get(cur)){
            if(depth[next.x] == -1){
                parent[next.x][0] = cur;
                maxDist[next.x][0] = next.dist;
                minDist[next.x][0] = next.dist;
                depth[next.x] = depth[cur] + 1;
                dfs(next.x);
            }
        }
    }
}

class Node{
    int x, dist;

    public Node(int x, int dist) {
        this.x = x;
        this.dist = dist;
    }
}