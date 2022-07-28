import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K, L, time = 1;
    static Queue<Command> q = new LinkedList();
    static Queue<Location> snake = new LinkedList();
    static int[][] map = new int[101][101];
    static int direction = 0;
    static Location snakeHead = new Location(0,0);

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i < K; i++)
            map[sc.nextInt()-1][sc.nextInt()-1] = 1;

        L = sc.nextInt();
        for(int i = 0; i < L; i++)
            q.offer(new Command(sc.nextInt() ,sc.next()));

        snake.offer(new Location(0,0));
        map[0][0] = 2;

        while(true){
            String turn;
            int count;

            if(q.isEmpty()){
                count = 987654321;
                turn = null;
            }else{
                turn = q.peek().direction;
                count = q.peek().seconds;
            }

            q.poll();
            for(int i = time; i <= count; i++){



                if(isInside(snakeHead.x+dx[direction],snakeHead.y+dy[direction])){

                    if(map[snakeHead.x+dx[direction]][snakeHead.y+dy[direction]] == 0){
                        map[snakeHead.x+dx[direction]][snakeHead.y+dy[direction]] = 2;
                        snake.offer(new Location(snakeHead.x+dx[direction],snakeHead.y+dy[direction]));
                        Location snakeTail = snake.poll();
                        map[snakeTail.x][snakeTail.y] = 0;
                        time++;
                    }
                    else if(map[snakeHead.x+dx[direction]][snakeHead.y+dy[direction]] == 1){
                        map[snakeHead.x+dx[direction]][snakeHead.y+dy[direction]] = 2;
                        snake.offer(new Location(snakeHead.x+dx[direction],snakeHead.y+dy[direction]));
                        time++;
                    }
                    else if(map[snakeHead.x+dx[direction]][snakeHead.y+dy[direction]] == 2){
                        System.out.println(time);
                        return;
                    }
                    snakeHead.x += dx[direction];
                    snakeHead.y += dy[direction];
                }
                else{
                    System.out.println(time);
                    return;
                }
                
            }
            if(turn.equals("D"))
                direction = (direction + 1) % 4;
            else if(turn.equals("L"))
                direction = (4 + direction - 1) % 4;
        }
    }

    static boolean isInside(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= N)
            return false;
        return true;
    }
}

class Command{
    int seconds;
    String direction;

    public Command(int seconds, String direction) {
        this.seconds = seconds;
        this.direction = direction;
    }
}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
