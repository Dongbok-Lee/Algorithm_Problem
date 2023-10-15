import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int result;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> reverseGraph = new ArrayList<>();

    static boolean[] visited;
    static boolean[] reverseV;
    static int arrS = 0;
    static int revArrS = 0;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!reverseGraph.get(a).contains(b)) {
                reverseGraph.get(a).add(b);
            }

            if(!graph.get(b).contains(a)) {
                graph.get(b).add(a);
            }
        }

        for (int i = 1; i <= N; i++) {

            visited = new boolean[N + 1];
            reverseV = new boolean[N + 1];
            arrS = 0;
            revArrS = 0;

            arrS = dfs(i);
            revArrS = reverseDfs(i);

            if (arrS > (N + 1)/2) {
                result++;
            }

            if (revArrS > (N + 1)/2) {
                result++;
            }
        }

        System.out.println(result);
    }

    static int dfs(int a) {

        int result = 1;
        visited[a] = true;

        for (int n : graph.get(a)) {
            if (!visited[n]) {
                result += dfs(n);
            }
        }

        return result;
    }

    static int reverseDfs(int a) {

        int result = 1;

        for (int n : reverseGraph.get(a)) {
            if (!visited[n]) {
                result += reverseDfs(n);
                visited[n] = true;
            }
        }

        return result;
    }
}
