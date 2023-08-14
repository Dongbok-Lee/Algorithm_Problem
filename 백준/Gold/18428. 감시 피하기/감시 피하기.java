import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static String[][] board;
    static LinkedList<Point> teacher = new LinkedList<>();
    static String result = "NO";


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();
                if (board[i][j].equals("T")) {
                    teacher.offer(new Point(i, j));
                }
            }
        }

        dfs(1, 0, 0);

        System.out.println(result);

    }

    public static void dfs(int obstacle, int x, int y) {

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j].equals("X")) {
                    board[i][j] = "O";

                    if (obstacle == 3) {
                        if (checkAvoid()) {
                            result = "YES";
                        }
                    } else {
                        int nextX = x + ((y + 1) / N);
                        int nextY = (y + 1) % N;
                        dfs(obstacle + 1, nextX, nextY);
                    }

                    board[i][j] = "X";
                }
            }
        }
    }

    public static boolean checkAvoid() {

        for (Point p : teacher) {

            for (int i = p.x + 1; i < N; i++) {
                if (isInside(i) && !board[i][p.y].equals("X")) {
                   if (board[i][p.y].equals("S")){
                       return false;
                   }
                   break;
                }
            }

            for (int i = p.x - 1; i >= 0; i--) {
                if (isInside(i) && !board[i][p.y].equals("X")) {
                    if (board[i][p.y].equals("S")){
                        return false;
                    }
                    break;
                }
            }

            for (int i = p.y + 1; i < N; i++) {
                if (isInside(i) && !board[p.x][i].equals("X")) {
                    if (board[p.x][i].equals("S")){
                        return false;
                    }
                    break;
                }
            }

            for (int i = p.y - 1; i >= 0; i--) {
                if (isInside(i) && !board[p.x][i].equals("X")) {
                    if (board[p.x][i].equals("S")){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static boolean isInside(int x) {
        return x >= 0 && x < N;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}