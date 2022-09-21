import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] map = new int[101][101];
    static Queue<Pair> queue = new LinkedList<Pair>();
    static int result = 1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        for (int i = 1; i < 100; i++) {
            int count = 0;
            boolean[][] visited = new boolean[101][101];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    if (visited[j][k] == false && map[j][k] > i) {
                        queue.offer(new Pair(j, k));
                        visited[j][k] = true;
                        count++;

                        while (!queue.isEmpty()) {
                            Pair p = queue.peek();
                            queue.poll();

                            for (int l = 0; l < 4; l++)
                                if (isInside(p.x+dx[l], p.y+dy[l]) && visited[p.x + dx[l]][p.y + dy[l]] == false && map[p.x + dx[l]][p.y + dy[l]] > i){
                                    visited[p.x+dx[l]][p.y+dy[l]] = true;
                                    queue.offer(new Pair(p.x+dx[l], p.y+dy[l]));

                                }
                        }
                    }


                }
            }
            result = Math.max(result,count);
        }
        System.out.println(result);
    }

    static boolean isInside(int x, int y) {
        if(x < 0 || x >= N)
            return false;
        if(y < 0 || y >= N)
            return false;

        return true;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
