import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static Tank[] tankList = new Tank[501];
    static ArrayList<Tank> result = new ArrayList<>();

    static int N;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();

        for(int i = 0; i < N; i++)
            tankList[i] = new Tank(i,sc.nextInt()-1,sc.nextInt()-1);


        //상하이동
        Arrays.sort(tankList,0, N,(x, y) -> x.x - y.x);

        ArrayList<Integer> upTank = new ArrayList<>(),downTank = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(tankList[i].x > i)
                upTank.add(i);
            if(tankList[i].x < i)
                downTank.add(i);
        }
        Collections.reverse(downTank);

        for(int i : upTank){
            for(int j = i; j < tankList[i].x; j++)
                result.add(new Tank('U', tankList[i]));
        }

        for(int i : downTank){
            for(int j = tankList[i].x; j < i; j++)
                result.add(new Tank('D', tankList[i]));
        }

        //좌우이동

        Arrays.sort(tankList,0, N,(x, y) -> x.y - y.y);

        ArrayList<Integer> leftTank = new ArrayList<>(),rightTank = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(tankList[i].y > i)
                leftTank.add(i);
            if(tankList[i].y < i)
                rightTank.add(i);
        }

        for(int i : leftTank){
            for(int j = i; j < tankList[i].y; j++)
                result.add(new Tank('L', tankList[i]));
        }

        for(int i : rightTank){
            for(int j = tankList[i].y; j < i; j++)
                result.add(new Tank('R', tankList[i]));
        }

        Collections.reverse(rightTank);

        System.out.println(result.size());

        for(Tank t : result)
            System.out.println((t.num+1) + " " + t.direction);
    }
}

class Tank{
    char direction;
    int num, x, y;

    public Tank(int num, int x, int y) {
        direction = 'N';
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public Tank(char direction, Tank tank) {
        this.direction = direction;
        this.num = tank.num;
        this.x = tank.x;
        this.y = tank.y;
    }
}