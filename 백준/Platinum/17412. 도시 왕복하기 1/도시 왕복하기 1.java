import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int START = 1;
    static int END = 2;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] capacity;
    static int[][] flow;
    static int[] parent;
    static int N, P, result;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        capacity = new int[N + 1][N + 1];
        flow = new int[N + 1][N + 1];
        parent = new int[N + 1];

        for(int i = 0 ; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
            capacity[from][to] = 1;
        }

        while(true) {
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(START);

            while(!q.isEmpty()) {
                int cur = q.poll();

                for(int next: list.get(cur)) {
                    if(capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = cur;
                        if(next == END)
                            break;
                    }
                }
            }

            if(parent[END] == -1)
                break;

            int minFlow = Integer.MAX_VALUE;

            for(int i = END; i != START; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for(int i = END; i != START; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            result += minFlow;
        }

        System.out.println(result);
    }
}

