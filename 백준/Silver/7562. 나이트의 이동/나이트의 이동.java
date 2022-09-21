import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, L;
    static Pair init_p;
    static Pair destination;
    static int[] dx = {2,2,-2,-2,1,1,-1,-1};
    static int[] dy = {1,-1,1,-1,2,-2,2,-2};

    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            L = sc.nextInt();
            boolean[][] visited = new boolean[301][301];
            init_p = new Pair(sc.nextInt(), sc.nextInt());
            destination = new Pair(sc.nextInt(), sc.nextInt());
            Queue<Move> q = new LinkedList<>();
            q.offer(new Move(init_p,0));
            visited[init_p.x][init_p.y] = true;

            while(!q.isEmpty()){
                Pair cur_pos = q.peek().p;
                int count = q.peek().count;

                q.poll();

                for(int j = 0; j < 8; j++) {
                    if (isInside(cur_pos.x + dx[j], cur_pos.y + dy[j]) && !visited[cur_pos.x + dx[j]][cur_pos.y + dy[j]]) {
                        visited[cur_pos.x + dx[j]][cur_pos.y + dy[j]] = true;
                        q.offer(new Move(new Pair(cur_pos.x + dx[j], cur_pos.y + dy[j]), count + 1));
                    }
                }

                if(cur_pos.x == destination.x && cur_pos.y == destination.y){
                    System.out.println(count);
                    break;
                }
            }
        }


    }

    static boolean isInside(int x, int y) {
        if(x < 0 || y < 0 || x >= L || y >= L)
            return false;
        return true;
    }
}
class Move{
    Pair p;
    int count;

    public Move(Pair p, int count) {
        this.p = p;
        this.count = count;
    }
}
class Pair{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
