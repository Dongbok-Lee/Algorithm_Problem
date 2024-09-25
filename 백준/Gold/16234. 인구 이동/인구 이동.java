import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, R, L;
    private static int result = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static boolean open = true;

    public static void main(String[] args) throws IOException {


        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(open) {
            open = false;
            visited = new boolean[N][N];
            int[][] temp = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        bfs(new Node(i, j), temp);
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = temp[i][j];
                }
            }

            if(open) {
                result++;
            }
        }

        System.out.println(result);

    }

    private static void bfs(Node node, int[][] temp) {

        Queue<Node> memoryQueue = new LinkedList<>();
        Queue<Node> searchQueue = new LinkedList<>();

        memoryQueue.add(node);
        searchQueue.add(node);

        visited[node.x][node.y] = true;

        int totalPeople = 0;

        while(!searchQueue.isEmpty()) {
            Node cur = searchQueue.poll();

            totalPeople += map[cur.x][cur.y];

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isInside(nx, ny) && !visited[nx][ny] && checkOpen(cur.x, cur.y, nx, ny)) {
                    open = true;
                    visited[nx][ny] = true;
                    memoryQueue.add(new Node(nx, ny));
                    searchQueue.add(new Node(nx, ny));
                }
            }
        }

        int resultPeople = totalPeople / memoryQueue.size();

        while(!memoryQueue.isEmpty()) {
            Node cur = memoryQueue.poll();
            temp[cur.x][cur.y] = resultPeople;
        }
    }

    private static boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static boolean checkOpen(int x, int y, int nx, int ny) {

        int diff = Math.abs(map[x][y] - map[nx][ny]);
        return diff >= R && diff <= L;
    }
}