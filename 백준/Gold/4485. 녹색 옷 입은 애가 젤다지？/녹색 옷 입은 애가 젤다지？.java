import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[][] board;
    static int[][] minDist;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.distance - n2.distance);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int stage = 1;

        while(N != 0) {
            board = new int[N][N];
            visited = new boolean[N][N];
            minDist = new int[N][N];

            for(int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    minDist[i][j] = 987654321;
                    if(board[i][j] != 0) {
                        pq.offer(new Node(i, j, board[i][j]));
                    }
                }
            }


            pq.offer(new Node(0, 0, board[0][0]));
            minDist[0][0] = board[0][0];

            while(!pq.isEmpty()) {
                Node curNode = pq.poll();

                visited[0][0] = true;
                for (int i = 0; i < 4; i++) {
                    if (isInside(curNode.x + dx[i], curNode.y + dy[i])) {
                        if (minDist[curNode.x + dx[i]][curNode.y + dy[i]] > minDist[curNode.x][curNode.y] + board[curNode.x + dx[i]][curNode.y + dy[i]]) {
                            minDist[curNode.x + dx[i]][curNode.y + dy[i]] = minDist[curNode.x][curNode.y] + board[curNode.x + dx[i]][curNode.y + dy[i]];

                            if (!visited[curNode.x + dx[i]][curNode.y + dy[i]]) {
                                pq.offer(new Node(curNode.x + dx[i], curNode.y + dy[i], minDist[curNode.x + dx[i]][curNode.y + dy[i]]));
                            }

                        }

                    }
                }
            }

            System.out.println("Problem " + stage + ": " + minDist[N - 1][N - 1]);
            stage++;
            N = Integer.parseInt(br.readLine());
        }


    }

    public static boolean isInside(int x, int y){
        return x >= 0 && y >= 0 && y < N && x < N;
    }

}

class Node {
    int x, y;
    int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

