import java.util.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int T, N, result = 0;
    
    public static void main(String[] args) {

        T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            result = 0;
            Coordinate start = new Coordinate(sc.nextInt(), sc.nextInt());
            Coordinate end = new Coordinate(sc.nextInt(), sc.nextInt());

            N = sc.nextInt();

            for(int j = 0; j < N; j++) {
                Coordinate cur = new Coordinate(sc.nextInt(), sc.nextInt());
                int r = sc.nextInt();
                double startToCur = start.getDistance(cur);
                double endToCur = end.getDistance(cur);

                if(startToCur > r && endToCur < r)
                    result++;

                if(startToCur < r && endToCur > r)
                    result++;
            }

            System.out.println(result);
        }
    }

    
}

class Coordinate{
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Coordinate p){
        int dx = (int)Math.pow(p.x - x,2);
        int dy = (int)Math.pow(p.y - y,2);

        return Math.sqrt(dx+dy);
    }
}