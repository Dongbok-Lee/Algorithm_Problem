//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//
//    static int START = 1;
//    static int END = 2;
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//
//    static int[][] capacity;
//    static int[][] flow;
//    static int[] parent;
//    static int N, P, result;
//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//
//        st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        P = Integer.parseInt(st.nextToken());
//
//        for(int i = 0; i <= N; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        capacity = new int[N + 1][N + 1];
//        flow = new int[N + 1][N + 1];
//        parent = new int[N + 1];
//
//        for(int i = 0 ; i < P; i++) {
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//
//            list.get(from).add(to);
//            list.get(to).add(from);
//            capacity[from][to] = 1;
//        }
//
//        while(true) {
//            Arrays.fill(parent, -1);
//            Queue<Integer> q = new ArrayDeque<>();
//            q.add(START);
//
//            while(!q.isEmpty()) {
//                int cur = q.poll();
//
//                for(int next: list.get(cur)) {
//                    if(capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
//                        q.add(next);
//                        parent[next] = cur;
//                        if(next == END)
//                            break;
//                    }
//                }
//            }
//
//            if(parent[END] == -1)
//                break;
//
//            int minFlow = Integer.MAX_VALUE;
//
//            for(int i = END; i != START; i = parent[i]) {
//                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
//            }
//
//            for(int i = END; i != START; i = parent[i]) {
//                flow[parent[i]][i] += minFlow;
//                flow[i][parent[i]] -= minFlow;
//            }
//
//            result += minFlow;
//        }
//
//        System.out.println(result);
//    }
//}
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int result;
    static int START = 2;
    static int END = 2;
    static Queue<Integer> q;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] capacity;
    static int[][] flow;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        parents = new int[N * 2 + 1];
        capacity = new int[N * 2 + 1][N * 2 + 1];
        flow = new int[N * 2 + 1][N * 2 + 1];

        graph = new ArrayList<>();

        for(int i = 0; i <= 2 * N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            graph.get(i * 2 - 1).add(2 * i);
            capacity[i * 2 - 1][2 * i] = 1;
        }


        for (int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from * 2).add(to * 2 - 1);
            graph.get(to * 2 - 1).add(from * 2);

            graph.get(to * 2).add(from * 2 - 1);
            graph.get(from * 2 - 1).add(to * 2);
            capacity[from * 2][to * 2 - 1] = 1;
            capacity[to * 2][from * 2 - 1] = 1;
        }

        while(true) {
            q = new ArrayDeque<>();

            Arrays.fill(parents, -1);

            q.add(START);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for(int next : graph.get(cur)) {

                    if(parents[next] == -1 && capacity[cur][next] > flow[cur][next]) {
                        parents[next] = cur;
                        q.add(next);
                    }

                    if(next == END * 2 - 1) {
                        break;
                    }
                }


            }

            if(parents[END * 2 - 1] == -1) {
                break;
            }

            for(int i = END * 2 - 1; parents[i] != 2; i = parents[i]) {
                flow[parents[i]][i]++;
                flow[i][parents[i]]--;
            }
            result++;
        }

        System.out.println(result);
    }
}