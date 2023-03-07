import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M, sccCount;
    static boolean[] visited;
    static int[] scc;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> backGraph;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 0; t < T; t++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            scc = new int[N + 1];
            sccCount = 0;
            graph = new ArrayList<>();
            backGraph = new ArrayList<>();
            stack = new Stack<>();

            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
                backGraph.add(new ArrayList<>());
            }

            for(int i = 0; i < M; i++){

                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                backGraph.get(to).add(from);
            }

            for(int i = 1; i <= N; i++){
                if(visited[i] == false)
                    dfs(i);
            }

            Arrays.fill(visited, false);

            while(!stack.isEmpty()){
                int cur = stack.pop();

                if(visited[cur] == false){
                    sccCount ++;
                    reDfs(cur);
                }
            }

            int[] inDegree =  new int[sccCount + 1];

            for(int i = 1; i <= N; i++){

                for(int j : graph.get(i)){
                    if(scc[i] != scc[j])
                        inDegree[scc[j]]++;
                }
            }

            int result = 0;

            for(int i : inDegree)
                if(i == 0)
                    result++;

            System.out.println(result - 1);
        }
    }

    static void dfs(int node){

        visited[node] = true;

        for(int i : graph.get(node)){
            if(visited[i] == false){
                dfs(i);
            }
        }

        stack.push(node);
    }

    static void reDfs(int node){

        visited[node] = true;
        scc[node] = sccCount;


        for(int i : backGraph.get(node)){
            if(visited[i] == false){
                reDfs(i);
            }
        }
    }
}
