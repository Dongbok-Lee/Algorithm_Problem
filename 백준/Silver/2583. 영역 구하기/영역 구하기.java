import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M, N, K;
    static int[][] map = new int[101][101];
    static Queue q = new LinkedList<Location>();
    static ArrayList counters = new ArrayList<Integer>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] ars) throws IOException {
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i < K; i++) {
           Location start = new Location(sc.nextInt(), sc.nextInt());
           Location end = new Location(sc.nextInt(), sc.nextInt());

           for(int j = start.x; j < end.x; j++)
               for(int k = start.y; k < end.y; k++)
                   map[j][k] = 1;
        }


        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                int count = 0;
                if(map[i][j] == 0){
                    q.offer(new Location(j,i));
                    count++;
                    map[i][j] = 1;
                }

                while(!q.isEmpty()){
                    Location cur = (Location)q.poll();

                    for(int k = 0; k < 4; k++){
                        int nextX = cur.x + dx[k];
                        int nextY = cur.y + dy[k];
                        if(isInside(nextX,nextY) && map[nextX][nextY] == 0){
                            map[nextX][nextY] = 1;
                            q.offer(new Location(nextY, nextX));
                            count++;
                        }
                    }
                }

                if(count != 0)
                    counters.add(count);
            }
        }

        Collections.sort(counters);

        System.out.println(counters.size());
        for(int i=0; i<counters.size(); i++)
            System.out.print(counters.get(i) + " ");
    }

    static boolean isInside(int x, int y){
        if(x < 0 || y < 0 || x >= M || y >= N)
            return false;
        return true;
    }
}

class Location{
    int x, y;

    public Location(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

