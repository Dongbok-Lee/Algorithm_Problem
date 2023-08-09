import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int turn = 0;
    static int[][] board;
    static Piece[] pieceList;
    static ArrayList<ArrayList<Queue<Piece>>> boardStatus;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N + 2][N + 2];
        boardStatus = new ArrayList<>();
        pieceList = new Piece[K];

        for (int i = 0; i <= N + 1; i++) {
            board[0][i] = 2;
            board[i][0] = 2;
            board[i][N + 1] = 2;
            board[N + 1][i] = 2;

        }

        boardStatus.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            boardStatus.add(new ArrayList<>());
            boardStatus.get(i).add(new LinkedList<>());

            for (int j = 1; j <= N; j++) {
                boardStatus.get(i).add(new LinkedList<>());
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            pieceList[i] = new Piece(n, m, k);
            boardStatus.get(n).get(m).add(pieceList[i]);
        }

        while (turn <= 1000) {
            turn++;

            for (Piece p : pieceList) {

                if (boardStatus.get(p.x).get(p.y).peek() == p) {
                    movePiece(p);
                    if (boardStatus.get(p.x).get(p.y).size() >= 4) {
                        System.out.println(turn);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static void movePiece(Piece p) {
        if (board[p.nextX()][p.nextY()] == 0) {
            int x = p.x;
            int y = p.y;
            int nextX = p.nextX();
            int nextY = p.nextY();

            while (!boardStatus.get(x).get(y).isEmpty()) {
                Piece piece = boardStatus.get(x).get(y).poll();
                boardStatus.get(nextX).get(nextY).offer(piece);

                piece.x = nextX;
                piece.y = nextY;

            }
        } else if (board[p.nextX()][p.nextY()] == 1) {

            Stack<Piece> stack = new Stack<>();
            int nextX = p.nextX();
            int nextY = p.nextY();

            while (!boardStatus.get(p.x).get(p.y).isEmpty()) {
                Piece piece = boardStatus.get(p.x).get(p.y).poll();

                stack.push(piece);
            }

            while (!stack.isEmpty()) {
                Piece piece = stack.pop();

                boardStatus.get(nextX).get(nextY).offer(piece);

                piece.x = nextX;
                piece.y = nextY;
            }
        } else if (board[p.nextX()][p.nextY()] == 2) {
            p.reverseDirection();
            if(board[p.nextX()][p.nextY()] != 2) {
                movePiece(p);
            }
        }
    }
}

class Piece {
    int x;
    int y;
    int direction;
    private final int[] dx = {0, 0, 0, -1, 1};
    private final int[] dy = {0, 1, -1, 0, 0};
    private final int[] reverse = {0, 2, 1, 4, 3};

    public Piece(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int nextX(){
        return x + dx[direction];
    }

    public int nextY() {
        return y + dy[direction];
    }

    public void reverseDirection(){
        direction = reverse[direction];
    }
}
