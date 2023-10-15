import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int result;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;

        result += graph.get(1).size();
        for (int i : graph.get(1)) {
            visited[i] = true;
        }

        for (int i : graph.get(1)) {
            for (int j : graph.get(i)) {
                if(!visited[j]) {
                    result++;
                    visited[j] = true;
                }
            }
        }

        System.out.println(result);
    }
}
