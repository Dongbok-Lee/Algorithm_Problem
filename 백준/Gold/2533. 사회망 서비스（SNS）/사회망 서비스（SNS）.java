import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, result = 0;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] children;
    static boolean[] earlyAdapterArr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            tree.add(new ArrayList<Integer>());

        children = new int[N + 1];
        children[0] = 1;
        earlyAdapterArr = new boolean[N + 1];
        earlyAdapterArr[0] = true;

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            children[u]++;
            children[v]++;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1, 0);

        System.out.println(result);
    }

    static void dfs(int node, int parent){
        children[node]--;
        for(int i : tree.get(node)){
            if(i != parent)
                dfs(i, node);
        }

        if(children[node] == 0 && earlyAdapterArr[node] == false){
            if(earlyAdapterArr[parent] == false){
                result++;
                earlyAdapterArr[parent] = true;
            }
        }
        children[parent]--;
    }
}