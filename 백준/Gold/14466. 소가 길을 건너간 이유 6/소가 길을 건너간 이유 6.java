import java.io.*;
import java.util.*;

class Main {

    static int N, K, R;
    static int result = 0;

    static boolean[][] farm;
    static Cow[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dx = {0, 0, -1, 1};
        int[] dx2 = {0, 0, -2, 2};
        int[] dy = {1, -1, 0, 0};
        int[] dy2 = {2, -2, 0, 0};

        st = new StringTokenizer(br.readLine());

        N = nextInt(st);
        K = nextInt(st);
        R = nextInt(st);

        farm = new boolean[2 * N][2 * N];
        cows = new Cow[K];


        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = nextInt(st);
            int y1 = nextInt(st);
            int x2 = nextInt(st);
            int y2 = nextInt(st);

            int roadX, roadY;

            if(x1 != x2) {
                roadX = ((x1 * 2) + (x2 * 2)) / 2 - 1;
                roadY = y1 * 2 - 1;
            } else {
                roadX = x1 * 2 - 1;
                roadY = ((y1 * 2) + (y2 * 2)) / 2 - 1;
            }

            farm[roadX][roadY] = true;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int cowX = nextInt(st) * 2 - 1;
            int cowY = nextInt(st) * 2 - 1;

            cows[i] = new Cow(cowX, cowY);
            farm[cowX][cowY] = true;
        }

        for (int i = 0; i < K - 1; i++) {
            Queue<Node> q = new ArrayDeque<>();
            int cowNumber = 0;
            boolean[][] visited = new boolean[2 * N][2 * N];

            q.offer(new Node(cows[i].x, cows[i].y));
            visited[cows[i].x][cows[i].y] = true;

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = cur.x + dx[j];
                    int nextY = cur.y + dy[j];

                    if (isInside(nextX, nextY) && !farm[nextX][nextY] && !visited[nextX][nextY]) {
                        Node nextNode = new Node(cur.x + dx2[j], cur.y + dy2[j]);
                        q.offer(nextNode);
                        visited[nextX][nextY] = true;
                        if(farm[nextNode.x][nextNode.y] && !visited[nextNode.x][nextNode.y]) {
                            cowNumber++;
                            visited[nextNode.x][nextNode.y] = true;
                        }
                    }
                }
            }

            farm[cows[i].x][cows[i].y] = false;
            result += (K - i - 1) - cowNumber;
        }
        System.out.println(result);
    }

    public static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    public static boolean isInside(int x, int y) {
        return x > 0 && x < 2 * N && y > 0 && y < 2 * N;
    }

}

class Cow {
    int x, y;

    public Cow(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

