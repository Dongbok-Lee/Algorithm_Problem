import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] scc;
    static boolean[] visited;
    static int N, M, sccCount = 1;
    static Stack<Integer> stack;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> backGraph;



    public static void main(String[] args) throws IOException {

        String input;

        while((input = br.readLine()) != null){

            sccCount = 1;

            st = new StringTokenizer(input);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            visited = new boolean[2 * N + 1];
            graph = new ArrayList<>();
            backGraph = new ArrayList<>();
            stack = new Stack<>();
            scc = new int[2  * N + 1];

            for(int i = 0; i <= 2 * N; i++){
                graph.add(new ArrayList<>());
                backGraph.add(new ArrayList<>());
            }

            graph.get(ifMinus(1)).add(ifMinus(-1));
            backGraph.get(ifMinus(-1)).add(ifMinus(1));

            for(int i = 0; i < M; i++){
                int a, b;

                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                graph.get(ifMinus(a)).add(ifMinus(-b));
                graph.get(ifMinus(b)).add(ifMinus(-a));
                backGraph.get(ifMinus(-b)).add(ifMinus(a));
                backGraph.get(ifMinus(-a)).add(ifMinus(b));
            }

            for(int i = 1; i <= 2 * N; i++){
                if(visited[i] == false){
                    dfs(i);
                }
            }

            Arrays.fill(visited, false);

            while(!stack.isEmpty()){

                int cur = stack.pop();

                if(visited[cur] == false){
                    reDfs(cur);
                    sccCount++;
                }
            }

            String isTrue = "yes";

            for(int i = 1; i <= N; i++){
                if(scc[i] == scc[N + i]){
                    isTrue = "no";
                    break;
                }
            }

            sb.append(isTrue + "\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur){

        visited[cur] = true;

        for(int next : graph.get(cur)){

            if(visited[next] == false){
                dfs(next);
            }
        }
        stack.push(cur);
    }

    static void reDfs(int cur){

        visited[cur] = true;
        scc[cur] = sccCount;
        for(int next : backGraph.get(cur)){

            if(visited[next] == false){
                reDfs(next);
            }
        }
    }

    static int ifMinus(int num){
        if(num < 0){
            num = Math.abs(num) + N;
        }

        return num;
    }

}
