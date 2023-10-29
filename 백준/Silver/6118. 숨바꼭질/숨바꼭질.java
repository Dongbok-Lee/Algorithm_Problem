import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int i : graph.get(cur)) {
                if(!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[cur] + 1;
                    q.offer(i);
                }
            }
        }

        int barnNum = 0;
        int barn = 1;
        int maxDistance = 0;

        for (int i = 1; i <= N; i++) {

            if(distance[i] == maxDistance) {
                barnNum++;
            }

            if(distance[i] > maxDistance) {
                barnNum = 1;
                barn = i;
                maxDistance = distance[i];
            }
        }

        System.out.println(barn + " " + maxDistance + " " + barnNum);
    }
}
