import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> backGraph;
    static ArrayList<ArrayList<Integer>> res;
    static boolean[] visited;
    static Stack<Integer> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());

        graph = new ArrayList<>();
        backGraph = new ArrayList<>();
        res = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
            backGraph.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            backGraph.get(to).add(from);
        }

        visited = new boolean[V + 1];
        stack = new Stack<>();

        for(int i = 1; i <= V; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        Arrays.fill(visited, false);
        int groupNum = 0;

        while (!stack.isEmpty()) {
            int start = stack.pop();

            if(visited[start]){
                continue;
            }

            reDfs(start, groupNum);

            groupNum++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(groupNum + "\n");

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < groupNum; i++){
            Collections.sort(res.get(i));
            map.put(res.get(i).get(0), i);
        }

        map.keySet().forEach(key -> {
            int value = map.get(key);

            for(int now : res.get(value)){
                sb.append(now + " ");
            }
            sb.append("-1\n");
        });

        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int start){
        visited[start] = true;

        for(int now : graph.get(start)){
            if(!visited[now]){
                dfs(now);
            }
        }

        stack.push(start);
    }

    public static void reDfs(int start, int groupNum){
        visited[start] = true;
        res.get(groupNum).add(start);

        for(int now: backGraph.get(start)){
            if(!visited[now]){
                reDfs(now, groupNum);
            }
        }
    }

}
