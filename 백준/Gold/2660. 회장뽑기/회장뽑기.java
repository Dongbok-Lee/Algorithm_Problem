import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] score;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Node> queue = new LinkedList<Node>();
    static int result = 987654321;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        score = new int[N + 1][N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++)  {
            graph.add(new ArrayList<>());
            Arrays.fill(score[i],987654321);
            score[i][i] = -1;
        }

        int a = 0;
        int b = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == -1) {
                break;
            }

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            queue.add(new Node(i, 1));

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                for (int n : graph.get(cur.x)) {
                    if(score[i][n] > cur.depth) {
                        queue.offer(new Node(n, cur.depth + 1));
                        score[i][n] = cur.depth;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {

            int max = 0;

            for (int s = 1; s <= N; s++) {
                max = Math.max(max, score[i][s]);
            }

            result = Math.min(result, max);
            score[0][i] = max;
        }

        int num = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            if (score[0][i] == result) {
                arr.add(i);
                num++;
            }
        }

        System.out.println(result + " " + num);
        for(int i : arr) {
            System.out.print(i + " ");
        }

    }

}

class Node {
    int x;
    int depth;

    public Node(int x, int depth) {
        this.x = x;
        this.depth = depth;
    }
}

