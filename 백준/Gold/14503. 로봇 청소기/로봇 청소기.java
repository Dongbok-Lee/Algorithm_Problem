import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, direction, count = 1;
    static int[][] map = new int[51][51];
    static boolean[][] cleaned = new boolean[51][51];
    static Location curLoc;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int[] backDx = {1,0,-1,0};
    static int[] backDy = {0,-1,0,1};

    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();
        M = sc.nextInt();

        curLoc = new Location(sc.nextInt(), sc.nextInt());
        direction = sc.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        map[curLoc.x][curLoc.y] = 2;

        while(true){

            boolean isMoveable = true;
            //4방향 왼쪽 체크
            for(int i = 0; i < 4; i++){
                int xLoc =  curLoc.x+dx[(4+direction-i)%4];
                int yLoc = curLoc.y+dy[(4+direction-i)%4];

                if(isInside(xLoc,yLoc) && map[xLoc][yLoc] == 0){
                    map[xLoc][yLoc] = 2;
                    curLoc.x = xLoc; curLoc.y = yLoc;
                    direction = (4 + direction - i-1) % 4;
                    count ++;
                    break;
                }

                if(i == 3)
                    isMoveable = false;
            }

            //네방향 못갈 때 뒤로
            if(!isMoveable){ //네 방향 못갈 때
               if(isInside(curLoc.x + backDx[direction], curLoc.y + backDy[direction]) && map[curLoc.x + backDx[direction]][curLoc.y + backDy[direction]] != 1){
                   curLoc.x += backDx[direction];
                   curLoc.y += backDy[direction];
               }
               else{
                   System.out.println(count);
                   break;
               }
            }
        }

    }
    static boolean isInside(int x, int y){
        if(x < 0 || x >= N && y < 0 || y >= M)
            return false;
        return true;
    }
}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
