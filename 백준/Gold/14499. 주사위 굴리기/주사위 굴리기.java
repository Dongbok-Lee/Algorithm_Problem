import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K;
    static int[][] map = new int[20][20];
    static Dice dice;

    public static void main(String[] args) throws IOException {

        N = sc.nextInt();
        M = sc.nextInt();

        //주사위 좌표
        dice = new Dice(new Location(sc.nextInt(), sc.nextInt()));

        K = sc.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        for(int i = 0; i < K; i++){
            int command =  sc.nextInt();

            if(dice.moveDice(command)){
                if(map[dice.diceLoc.x][dice.diceLoc.y] == 0)
                    map[dice.diceLoc.x][dice.diceLoc.y] = dice.direction[1];
                else{
                    dice.direction[1] = map[dice.diceLoc.x][dice.diceLoc.y];
                    map[dice.diceLoc.x][dice.diceLoc.y] = 0;
                }

                dice.printTop();
            }
        }

        return;
    }

}

class Dice{
    //위 아래 앞 뒤 왼 오
    int[] direction = new int[6];
    Location diceLoc;

    public Dice(Location diceLoc) {
        this.diceLoc = diceLoc;
    }

    public boolean moveDice(int command){
        Location nextLoc;

        switch(command){
            case 1://동
                nextLoc = new Location(this.diceLoc.x, this.diceLoc.y+1);
                if(nextLoc.isInside()){
                    diceLoc = nextLoc;
                    int tmp = direction[0];
                    direction[0] = direction[4];
                    direction[4] = direction[1];
                    direction[1] = direction[5];
                    direction[5] = tmp;
                    return true;
                }
                else
                    return false;
            case 2://서
                nextLoc = new Location(this.diceLoc.x, this.diceLoc.y-1);
                if(nextLoc.isInside()){
                    diceLoc = nextLoc;
                    int tmp = direction[0];
                    direction[0] = direction[5];
                    direction[5] = direction[1];
                    direction[1] = direction[4];
                    direction[4] = tmp;
                    return true;
                }
                else
                    return false;
            case 3://북
                nextLoc = new Location(this.diceLoc.x-1, this.diceLoc.y);
                if(nextLoc.isInside()){
                    diceLoc = nextLoc;
                    int tmp = direction[0];
                    direction[0] = direction[2];
                    direction[2] = direction[1];
                    direction[1] = direction[3];
                    direction[3] = tmp;
                    return true;
                }
                else
                    return false;
            case 4://남
                nextLoc = new Location(this.diceLoc.x+1, this.diceLoc.y);
                if(nextLoc.isInside()){
                    diceLoc = nextLoc;
                    int tmp = direction[0];
                    direction[0] = direction[3];
                    direction[3] = direction[1];
                    direction[1] = direction[2];
                    direction[2] = tmp;
                    return true;
                }
                else
                    return false;
        }
        return false;
    }

    public void printTop(){
        System.out.println(direction[0]);
    }



}

class Location{
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInside(){
        if(x < 0 || y < 0 || x >= Main.N || y >= Main.M)
            return false;
        return true;
    }
}
