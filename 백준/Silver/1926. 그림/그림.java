import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] paper;
    static boolean[][] visited;
    static final int[] DY = {-1, 0, 0, 1};
    static final int[] DX = {0, -1, 1, 0};
    static int N, M;
    static Queue<Point> q;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        int result = 0;

        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());

                if(paper[i][j] == 1){
                    q.offer(new Point(i, j));
                }
            }
        }

        int paintNum = 0;

        while(!q.isEmpty()){
            int size = 0;

            Point cur = q.poll();

            Queue<Point> bfsQ = new LinkedList<>();

            if(!visited[cur.y][cur.x]){
                visited[cur.y][cur.x] = true;
                bfsQ.offer(cur);
                paintNum++;
            }


            while(!bfsQ.isEmpty()){
                size++;
                Point curP = bfsQ.poll();
                for(int i = 0; i < 4; i++){
                    int nextX = curP.x + DX[i];
                    int nextY = curP.y + DY[i];

                    if(isInside(nextX, nextY) && paper[nextY][nextX] == 1){
                        if(!visited[nextY][nextX]){
                            visited[nextY][nextX] = true;
                            bfsQ.offer(new Point(nextY, nextX));
                        }
                    }
                }
            }

            result = Math.max(result, size);
        }
        System.out.println(paintNum);
        System.out.println(result);
    }

    static boolean isInside(int x, int y){
        return 0 <= x && x < M && 0 <= y && y < N;
    }

    static class Point{
        int x, y;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}