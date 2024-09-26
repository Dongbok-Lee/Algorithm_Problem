import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, maxSize = 0, minLength = Integer.MAX_VALUE;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == '#') {
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(maxSize + " " + minLength);


    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();

        int size = 1;
        int length = 0;

        q.offer(node);
        visited[node.x][node.y] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isInside(nx, ny) && map[nx][ny] == '#' && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    size++;
                    visited[nx][ny] = true;
                }else if((isInside(nx, ny) && map[nx][ny] != '#') || !isInside(nx, ny)) {
                    length++;
                }
            }
        }

        if(maxSize < size) {
            maxSize = size;
            minLength = length;
        }

        if(maxSize == size && minLength > length) {
            minLength = length;
        }
    }

    private static boolean isInside(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}