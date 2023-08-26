import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static char[] direction = {'L', 'D', 'R', 'U'};
    static int[][] board;
    static int N, result = 0;

    static int[][] left = {
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0},
    };
    static int[][] right = {
            {0, 0, 2, 0, 0},
            {0, 1, 7, 10, 0},
            {0, 0, 0, 0, 5},
            {0, 1, 7, 10, 0},
            {0, 0, 2, 0, 0},
    };
    static int[][] up = {
            {0, 0, 5, 0, 0},
            {0, 10, 0, 10, 0},
            {2, 7, 0, 7, 2},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
    };

    static int[][] down = {
            {0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {2, 7, 0, 7, 2},
            {0, 10, 0, 10, 0},
            {0, 0, 5, 0, 0},
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Point curPoint = new Point(N / 2, N / 2);

        int dIndex = -1;
        int distance = 1;

        while (true) {
            dIndex++;
            distance++;
            dIndex %= 4;

            for (int i = 0; i < distance/2; i++) {
                curPoint.nextPoint(direction[dIndex]);
                if (!curPoint.isInside(N)){
                    System.out.println(result);
                    return;
                }
                result += tornado(curPoint, direction[dIndex]);
            }
        }

    }

    static int tornado(Point p, char direction) {

        int result = 0;

        switch(direction) {
            case 'L':
                result += calculate(p, left, direction);
                break;
            case 'R':
                result += calculate(p, right, direction);
                break;
            case 'U':
                result += calculate(p, up, direction);
                break;
            case 'D':
                result += calculate(p, down, direction);
                break;
        }

        return result;
    }

    static int calculate(Point p, int[][] sandBoard, char direction) {

        int result = 0;
        int totalSand = board[p.y][p.x];

        Point calPoint = new Point(p.x, p.y);

        for (int i = 0; i < 5; i++) {
            calPoint.y = p.y + i - 2;
            for (int j = 0; j < 5; j++) {
                calPoint.x = p.x + j - 2;
                if (calPoint.isInside(N)) {
                    board[calPoint.y][calPoint.x] += board[p.y][p.x] * sandBoard[i][j] / 100;
                } else {
                    result += board[p.y][p.x] * sandBoard[i][j] / 100;
                }
                totalSand -= board[p.y][p.x] * sandBoard[i][j] / 100;
            }
        }

        Point nextPoint = new Point(p.x, p.y);
        nextPoint.nextPoint(direction);

        if (nextPoint.isInside(N)) {
            board[nextPoint.y][nextPoint.x] += totalSand;
        } else {
            result += totalSand;
        }

        return result;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void nextPoint(char direction) {
            switch(direction) {
                case 'L' :
                    x--;
                    break;
                case 'R' :
                    x++;
                    break;
                case 'U' :
                    y--;
                    break;
                case 'D' :
                    y++;
                    break;
            }
        }

        public boolean isInside(int N) {
            return 0 <= x && 0 <= y && x < N && y < N;
        }
    }
}