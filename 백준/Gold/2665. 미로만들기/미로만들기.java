import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[][] board;
    static int[][] minBlack;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0 ,1};
    static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.black - n2.black);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        minBlack = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(minBlack[i], 987654321);
            String str = br.readLine();

            for(int j = 1; j <= N; j++){
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j - 1)));
            }
        }

        pq.offer(new Node(1 ,1, 0));
        visited[1][1] = true;
        minBlack[1][1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int curX = cur.x + dx[i];
                int curY = cur.y + dy[i];
                int curBlack = cur.black;

                if(isInside(curX, curY) && !visited[curX][curY]) {
                    if(board[curX][curY] == 0) {
                        curBlack++;
                    }

                    if (minBlack[curX][curY] > curBlack) {
                        minBlack[curX][curY] = curBlack;
                        pq.offer(new Node(curX, curY, curBlack));
                        visited[curX][curY] = true;
                    }
                }
            }


        }

        System.out.println(minBlack[N][N]);
    }

    static boolean isInside(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= N;
    }

    static class Node {
        int x;
        int y;
        int black;

        public Node(int x, int y, int black) {
            this.x = x;
            this.y = y;
            this.black = black;
        }

    }
}

