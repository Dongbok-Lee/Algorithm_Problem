import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static int[] parent, level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        level = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            graph[p].add(s);
            graph[s].add(p);
        }
        initTree(0, 1, 1);

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = getLCA(a, b);
            sb.append(result + "\n");

        }
        System.out.println(sb);
    }



    static void initTree(int p, int c, int l) {
        parent[c] = p;
        level[c] = l;

        for(int num : graph[c]) {
            if(num != p){
                initTree(c, num, l + 1);
            }
        }
    }

    static int getLCA(int a, int b) {

        while (level[a] < level[b]) {
            b = parent[b];
        }

        while (level[a] > level[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}