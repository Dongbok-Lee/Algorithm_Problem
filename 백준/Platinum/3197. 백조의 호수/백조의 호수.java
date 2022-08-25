import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, swanX, swanY;
    static char[][] map = new char[1501][1501];
    static StringTokenizer st;
    static Queue<Location> iceQ = new LinkedList<>();
    static Queue<Location> swanQ = new LinkedList<>();
    static boolean[][] visited = new boolean[1501][1501];
    static boolean[][] visited2 = new boolean[1501][1501];
    static int result = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'L' || map[i][j] == '.'){
                    if(map[i][j] == 'L'){
                        swanX = i; swanY = j;
                    }
                    visited[i][j] = true;
                    iceQ.offer(new Location(i, j));
                }
            }
        }

        swanQ.offer(new Location(swanX, swanY));
        visited2[swanX][swanY] = true;

        while(true){
            Queue<Location> swanQ2 = new LinkedList<>();
            Queue<Location> iceQ2 = new LinkedList<>();

            while(!swanQ.isEmpty()){
                Location curLoc = swanQ.poll();

                for(int i = 0; i < 4; i++){
                    int nextX = curLoc.x + dx[i];
                    int nextY = curLoc.y + dy[i];

                    if(isInside(nextX, nextY) && visited2[nextX][nextY] == false){
                        visited2[nextX][nextY] = true;
                        if(map[nextX][nextY] == '.')
                            swanQ.offer(new Location(nextX,nextY));
                        else if(map[nextX][nextY] == 'X')
                            swanQ2.offer(new Location(nextX, nextY));
                        else if(map[nextX][nextY] == 'L'){
                            System.out.println(result);
                            return;
                        }
                    }
                }

            }

            if(swanQ.isEmpty())
                while(!swanQ2.isEmpty())
                    swanQ.offer(swanQ2.poll());


            while(!iceQ.isEmpty()) {
                Location curLoc = iceQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = curLoc.x + dx[i];
                    int nextY = curLoc.y + dy[i];

                    if (isInside(nextX, nextY) && visited[nextX][nextY] == false) {
                        visited[nextX][nextY] = true;
                        iceQ2.offer(new Location(nextX, nextY));
                        map[nextX][nextY] = '.';
                    }
                }
            }
            if(iceQ.isEmpty())
                while(!iceQ2.isEmpty())
                    iceQ.offer(iceQ2.poll());

            result++;
        }

    }

    static boolean isInside(int x, int y){
        if(x < 0 || y < 0 || x >= R || y >= C)
            return false;
        return true;
    }
    static void printMap(){
        for(int i = 0; i < R; i++){
            System.out.println();
            for(int j = 0; j < C; j++)
                System.out.print(map[i][j] + " ");
        }
        System.out.println();

    }
}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
