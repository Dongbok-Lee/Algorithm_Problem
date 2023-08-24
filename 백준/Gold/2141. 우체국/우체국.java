import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static long result = 0;
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        node = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int village = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            node[i] = new Node(village, people);
            result += people;
        }

        Arrays.sort(node);

        long sum = 0;

        for ( Node n : node) {
            sum += n.p;

            if (sum >= (result + 1) / 2) {
                System.out.println(n.v);
                return;
            }
        }
    }

    static class Node implements Comparable<Node> {
        long v;
        long p;

        public Node(long v, long p) {
            super();
            this.v = v;
            this.p = p;
        }

        public int compareTo(Node n) {
            if (this.v == n.v) {
                return 0;
            }

            return (int) (this.v - n.v);
        }
    }
}