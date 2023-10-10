import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] minDistance;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.distance - n2.distance);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minDistance = new int[N + 1];
        visited = new boolean[N + 1];

        graph = new ArrayList<>();

        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[1] = 0;

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, distance));
            graph.get(end).add(new Node(start, distance));
        }

        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (minDistance[curNode.end] < curNode.distance) {
                continue;
            }

            for (Node n : graph.get(curNode.end)) {
                if(minDistance[n.end] > curNode.distance + n.distance) {
                    minDistance[n.end] = curNode.distance + n.distance;
                    pq.offer(new Node(n.end, minDistance[n.end]));
                }
            }
        }

        System.out.println(minDistance[N]);

    }


}

class Node {
    int end;
    int distance;

    public Node(int end, int distance) {
        this.end = end;
        this.distance = distance;
    }
}



