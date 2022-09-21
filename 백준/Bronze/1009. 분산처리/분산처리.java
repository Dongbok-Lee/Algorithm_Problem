import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    static int A, B;


    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            A = sc.nextInt();
            B = sc.nextInt();

            System.out.println(fastPow(A,B)==0 ? 10 : fastPow(A,B));

        }
    }

    static int fastPow(int x, int y){
        if(y == 1)
            return x%10;

        if(y%2 == 1)
            return (x * fastPow(x, y-1))%10;
        else
            return fastPow((x*x)%10,y/2)%10;

    }
}
