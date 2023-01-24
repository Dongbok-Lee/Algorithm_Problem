import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> list;
    static int N, M;
    static final int MAX_LEVEL = 16;
    static int[] depth;
    static int[][] dp;
    static int[] distance;
    static boolean[] visited;




    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(reader.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<ArrayList<Node>>();
        depth = new int[N + 1];
        distance = new int[N +1];
        dp = new int[N + 1][MAX_LEVEL + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) list.add(new ArrayList<Node>());


        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(reader.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.get(x).add(new Node(y, d));
            list.get(y).add(new Node(x, d));
        }

        visited[1] = true;
        depth[1] = 0;
        setTree(1);

        memoizationParents();

        st = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(reader.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lca = getLCA(x, y);

            System.out.println(distance[x] + distance[y] - distance[lca] * 2);
        }
    }

    static void setTree(int cur){

       for(Node node: list.get(cur)){
           if(!visited[node.next]){
               visited[node.next] = true;
               depth[node.next] = depth[cur] + 1;
               dp[node.next][0] = cur;
               distance[node.next] = distance[cur] + node.dist;

               setTree(node.next);
           }
       }
    }

    static void memoizationParents(){
        for(int y = 1; y <= MAX_LEVEL; y++) {
            for(int x = 1; x <= N; x++) {
                dp[x][y] = dp[dp[x][y-1]][y-1];
            }
        }
    }

    static int getLCA(int x, int y){

        if(depth[x] < depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }

        for(int i = MAX_LEVEL; i >= 0; i--) {
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                x = dp[x][i];
            }
        }

        if(x == y) return x;
        else {
            for(int i = MAX_LEVEL; i >= 0; i--) {
                if(dp[x][i] != dp[y][i]) {
                    x = dp[x][i];
                    y = dp[y][i];
                }
            }
            x = dp[x][0];
        }
        return x;
    }
}

class Node{
    int next;
    int dist;

    public Node(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }
}