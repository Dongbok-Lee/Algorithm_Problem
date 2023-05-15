import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, N;
    static char[][] map;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }

        if(N%2 == 0){
            initMap(map);
            printMap(map);
            return;
        }


        Queue<Point> q = new LinkedList<>();

        N = N / 2;

        while(N-- > 0){
            findBomb(map, q);
            initMap(map);
            bomb(map, q);
        }

        printMap(map);
    }

    static void findBomb(char[][] map, Queue<Point> q){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'O'){
                    q.add(new Point(j, i));
                }
            }
        }
    }

    static void bomb(char[][] map, Queue<Point> q){
        int[] dx = {0, 0, -1, 1, 0};
        int[] dy = {0, 1, 0, 0, -1};

        while(!q.isEmpty()){

            Point curPoint = q.poll();



            for(int i = 0; i < 5; i++){

                int x = curPoint.x + dx[i];
                int y = curPoint.y + dy[i];
                if(isInside(0, R, y) && isInside(0, C, x)){
                    map[y][x] = '.';
                }
            }
        }

    }

    static boolean isInside(int x, int y, int num){
        return 0 <= num && num < y;
    }


    static void initMap(char[][] map){
        for(int i = 0; i < R; i++){
            for(int j = 0 ; j < C; j++){
                map[i][j] = 'O';
            }
        }
    }

    static void printMap(char[][] map){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }



    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}