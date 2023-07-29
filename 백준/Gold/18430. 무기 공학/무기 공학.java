import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    //dfs
    //신경쓸 점: 케이스 나누기
    //          탈출 조건

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Coordinate[][] boomerangCase = {
            {new Coordinate(1, 0), new Coordinate(0, 0), new Coordinate(0, 1)},
            {new Coordinate(1, 0), new Coordinate(0, 0), new Coordinate(0, -1)},
            {new Coordinate(-1, 0), new Coordinate(0, 0), new Coordinate(0, 1)},
            {new Coordinate(-1, 0), new Coordinate(0, 0), new Coordinate(0, -1)},
    };

    static int result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeBoomerang(new Coordinate(0, 0), 0);

        System.out.println(result);
    }

    public static void makeBoomerang(Coordinate cur, int totalStrength) {

        if(cur.x >= N){
            result = Math.max(result, totalStrength);
            return;
        }

        for (Coordinate[] coordinates : boomerangCase) {

            boolean able = true;

            for (Coordinate coordinate : coordinates) {
                if (!checkInside(cur.x + coordinate.x, cur.y + coordinate.y) || visited[cur.x + coordinate.x][cur.y + coordinate.y]) {
                    able = false;
                    break;
                }
            }

            if(able){
                for (Coordinate coordinate : coordinates) {
                    if(coordinate.x == 0 && coordinate.y == 0){
                        totalStrength += board[cur.x + coordinate.x][cur.y + coordinate.y] * 2;
                    }else{
                        totalStrength += board[cur.x + coordinate.x][cur.y + coordinate.y];
                    }

                    visited[cur.x + coordinate.x][cur.y + coordinate.y] = true;
                }

                makeBoomerang(cur.nextCoordinate(M), totalStrength);

                for (Coordinate coordinate : coordinates) {
                    if(coordinate.x == 0 && coordinate.y == 0){
                        totalStrength -= board[cur.x + coordinate.x][cur.y + coordinate.y] * 2;
                    }else{
                        totalStrength -= board[cur.x + coordinate.x][cur.y + coordinate.y];
                    }

                    visited[cur.x + coordinate.x][cur.y + coordinate.y] = false;
                }
            }
        }
        makeBoomerang(cur.nextCoordinate(M), totalStrength);
    }

    public static boolean checkInside(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate nextCoordinate(int m){
        int x2 = x;
        int y2 = y;
        y2++;
        if(y2 >= m){
            x2++;
            y2 = 0;
        }
        return new Coordinate(x2, y2);
    }
}

