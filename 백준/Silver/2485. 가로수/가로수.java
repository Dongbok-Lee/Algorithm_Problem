import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, minNum = -1, result;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        int previousNum = Integer.parseInt(br.readLine());
        int firstTree = previousNum;

        for(int i = 0; i < N - 1; i++){
            int curNum = Integer.parseInt(br.readLine());

            int gap =curNum - previousNum;

            minNum = getGCD(minNum, gap);

            previousNum = curNum;

            if(i == N -2){
                result = (curNum - firstTree) / minNum - N + 1;
            }
        }

        System.out.println(result);
    }

    static int getGCD(int x, int y){

        int GCD = 0;
        if(x == -1)
            return y;

        for(int i = 1; i <= Math.min(x, y) / 2 ; i++){
            if(x % i == 0 && y % i == 0){
                GCD = i;
            }
        }

        if(x % Math.min(x, y) == 0 && y % Math.min(x, y) == 0){
            GCD = Math.min(x, y);
        }

        return GCD;
    }
}