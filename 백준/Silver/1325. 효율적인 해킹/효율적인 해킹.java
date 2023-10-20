import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] max;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i =0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            int computer = 0;
            visited[i] = true;
            q.offer(i);


            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int num : graph.get(cur)) {
                    if(!visited[num]) {
                        visited[num] = true;
                        q.offer(num);
                        computer++;
                    }
                }
            }

            max[i] = computer;
            result = Math.max(result, computer);
        }

        for(int i = 1; i <= N; i++) {
            if (max[i] == result) {
                System.out.print(i + " ");
            }
        }
    }

}

