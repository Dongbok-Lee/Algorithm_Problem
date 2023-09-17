import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] result;
    static Point goal;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(result[i], -1);
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= M; j++) {
                int point = Integer.parseInt(st.nextToken());
                if (point == 2) {
                   goal = new Point(i, j, 0);
                }

                if (point == 0) {
                    result[i][j] = 0;
                }
            }
        }

        q.add(goal);
        result[goal.x][goal.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int distance = cur.distance;

            for(int i = 0; i < 4; i++) {
                int curX = cur.x + dx[i];
                int curY = cur.y + dy[i];

                if (isInside(curX, curY) && result[curX][curY] == -1) {
                    result[curX][curY] = distance + 1;
                    q.add(new Point(curX, curY, distance + 1));
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (j == M) {
                    System.out.println(result[i][j]);
                }else {
                    System.out.print(result[i][j] + " ");
                }
            }
        }
    }

    public static boolean isInside (int x, int y) {
        return x <= N && y <= M && x > 0 && y > 0;
    }


}

class Point {
    int x, y, distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}