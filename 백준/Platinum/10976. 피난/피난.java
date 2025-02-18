import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, result;
    static Queue<Integer> q;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] capacity;
    static int[][] flow;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            result = 0;

            graph = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            parents = new int[n + 1];


            capacity = new int[n + 1][n + 1];
            flow = new int[n + 1][n + 1];

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(from == 1 || to == 1 || from == n || to == n) {
                    capacity[from][to] = 1;
                }else {
                    capacity[from][to] = 999999999;
                }

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            while(true) {
                Arrays.fill(parents, -1);
                q = new ArrayDeque<>();

                int start = 1;

                q.add(start);

                while(!q.isEmpty()) {

                    int cur = q.poll();

                    for(int num : graph.get(cur)) {
                        if(parents[num] == -1 && capacity[cur][num] > flow[cur][num]) {
                            q.add(num);
                            parents[num] = cur;
                            if(num == n) {
                                break;
                            }

                        }
                    }
                }

                if(parents[n] == -1) {
                    break;
                }

                for(int i = n; i != 1; i = parents[i]) {
                    flow[parents[i]][i]++;
                    flow[i][parents[i]]--;
                }

                result++;
                if(result == 1000) {
                    break;
                }
            }

            System.out.println(result);
        }
    }
}