import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static boolean[][] map = new boolean[101][101];
    static int result = 0;
    public static void main(String[] args) throws Exception {

        for(int i = 0; i < 4; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();

            for(int j = x; j < x2; j++){
                for(int k = y; k < y2; k++){
                    map[j][k] = true;
                }
            }
        }

        for(int i = 0; i <= 100; i++){
            for(int j = 0; j <=100; j++){
                if(map[i][j] == true)
                    result +=1;
            }
        }

        System.out.println(result);
    }
}


