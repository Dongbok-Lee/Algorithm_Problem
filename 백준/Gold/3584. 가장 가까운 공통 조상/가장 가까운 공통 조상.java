import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] parent, level;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int T, N;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            tree = new ArrayList<>();
            parent = new int[N + 1];
            level = new int[N + 1];

            for (int k = 0; k < N + 1; k++) {
                tree.add(new ArrayList<>());
            }

            for (int j = 0; j < N - 1; j++) {

                st = new StringTokenizer(br.readLine());

                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                tree.get(p).add(c);
                parent[c] = p;
            }

            int root = 0;

            for (int j = 1; j < N + 1; j++) {
                if (parent[j] == 0) {
                    root = j;
                }
            }

            setTree(root, 1);

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = lca(a, b);

            System.out.println(result);
        }
    }

    static void setTree(int cur, int depth) {

        level[cur] = depth;

        for (int next : tree.get(cur)) {
                setTree(next, depth + 1);
        }
    }

    static int lca (int a, int b) {
        int aDepth = level[a];
        int bDepth = level[b];

        if (aDepth < bDepth) {
           int tmp = bDepth;
           bDepth = aDepth;
           aDepth = tmp;

           tmp = b;
           b = a;
           a = tmp;
        }

        while (aDepth > bDepth) {
            a = parent[a];
            aDepth = level[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

}