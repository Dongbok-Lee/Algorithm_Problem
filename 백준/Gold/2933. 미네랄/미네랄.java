import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, N;
    static char[][] cave = new char[101][101];
    static int[] attackFloor =  new int[101];
    static Queue<Location> q = new LinkedList<>();
    static StringTokenizer st;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++)
                cave[i][j] = str.charAt(j);
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            attackFloor[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            attack(i);
            checkCluster();
        }
        printCave();
    }

    static void attack(int n){
        if(n%2 == 0){
            for(int i = 0; i < C; i++){
                if(cave[R-attackFloor[n]][i] == 'x'){
                    cave[R-attackFloor[n]][i] = '.';
                    break;
                }
            }
        }
        else{
            for(int i = C-1; i >= 0; i--){
                if(cave[R-attackFloor[n]][i] == 'x'){
                    cave[R-attackFloor[n]][i] = '.';
                    break;
                }
            }
        }
    }

    static void checkCluster(){
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(cave[i][j] == 'x' && visited[i][j] == false) {
                    q.offer(new Location(i, j));

                    ArrayList<Location> clusterQ = new ArrayList<>();

                    while (!q.isEmpty()) {
                        Location curLoc = q.poll();
                        cave[curLoc.x][curLoc.y] = '.';
                        clusterQ.add(curLoc);

                        for (int k = 0; k < 4; k++) {
                            int nextX = curLoc.x + dx[k];
                            int nextY = curLoc.y + dy[k];
                            if (isInside(nextX, nextY) && visited[nextX][nextY] == false) {
                                if (cave[nextX][nextY] == 'x') {
                                    visited[nextX][nextY] = true;
                                    q.offer(new Location(nextX, nextY));
                                }
                            }
                        }
                    }


                    //하나씩 내려보기
                    int move = 0;
                    boolean toContinue = true;
                    while (toContinue) {
                        for (int a = 0; a < clusterQ.size(); a++) {


                            if (cave[clusterQ.get(a).x + move][clusterQ.get(a).y] == 'x') {
                                move--;
                                for (int b = 0; b < clusterQ.size(); b++)
                                    visited[clusterQ.get(b).x][clusterQ.get(b).y] = false;


                                for (int b = 0; b < clusterQ.size(); b++){
                                    cave[clusterQ.get(b).x + move][clusterQ.get(b).y] = 'x';
                                    visited[clusterQ.get(b).x + move][clusterQ.get(b).y] = true;
                                }
                                toContinue = false;
                                break;
                            }
                            else if (clusterQ.get(a).x + move == R -1) {
                                for (int b = 0; b < clusterQ.size(); b++)
                                    visited[clusterQ.get(b).x][clusterQ.get(b).y] = false;
                                for (int b = 0; b < clusterQ.size(); b++){
                                    cave[clusterQ.get(b).x + move][clusterQ.get(b).y] = 'x';
                                    visited[clusterQ.get(b).x + move][clusterQ.get(b).y] = true;
                                }
                                toContinue = false;
                                break;
                            }
                        }
                        move++;
                    }
                }
            }
        }
    }


    static boolean isInside(int x, int y){
        if(x < 0 || y < 0 || x >= R || y >= C)
            return false;
        return true;
    }

    static void printCave(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
                System.out.print(cave[i][j]);
            System.out.println();
        }
    }
}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
