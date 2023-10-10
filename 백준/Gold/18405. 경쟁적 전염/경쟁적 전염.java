import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.virus - n2.virus);
    static PriorityQueue<Node> pq2 = new PriorityQueue<Node>((n1, n2) -> n1.virus - n2.virus);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0) {
                    pq.offer(new Node(i, j, board[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());

        for(int i = 0; i <s; i++) {

            while(!pq.isEmpty()) {
                Node curNode = pq.poll();

                for(int l = 0; l < 4; l++) {
                    if(isInside(curNode.x + dx[l], curNode.y + dy[l]) && board[curNode.x + dx[l]][curNode.y + dy[l]] == 0) {
                        board[curNode.x + dx[l]][curNode.y + dy[l]] = curNode.virus;
                        pq2.add(new Node(curNode.x + dx[l], curNode.y + dy[l], curNode.virus));
                    }
                }
            }

            pq = pq2;
            pq2 = new PriorityQueue<Node>((n1, n2) -> n1.virus - n2.virus);
        }

        System.out.println(board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
    }

    public static boolean isInside(int x, int y){
        return x > 0 && y > 0 && y <= N && x <= N;
    }

}

class Node {
    int x, y;
    int virus;

    public Node(int x, int y, int virus) {
        this.x = x;
        this.y = y;
        this.virus = virus;
    }
}

