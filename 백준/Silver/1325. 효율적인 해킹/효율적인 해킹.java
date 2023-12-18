import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] depthArr;
    static ArrayList<Integer>[] graph;
    static int max;
    static int depth;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        N = readInt();
        M = readInt();

        graph = new ArrayList[N + 1];
        depthArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i =0 ; i < M; i++) {
            int a = readInt();
            int b = readInt();

            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            depth = 0;
            dfs(i, 0);
            depthArr[i] = depth;
            max = Math.max(max, depth);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            if (max == depthArr[i]) {
                sb.append(i + " ");
            }
        }
        System.out.print(sb);
    }

    static void dfs(int v, int d) {
        visited[v] = true;
        for (int i : graph[v]) {
            if (!visited[i]) {
                depth++;
                dfs(i, d + 1);
            }
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}