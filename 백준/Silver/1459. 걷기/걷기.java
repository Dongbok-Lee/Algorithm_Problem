import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static long X, Y, W, S;


    public static void main(String[] args) throws Exception {
        X = sc.nextLong();
        Y = sc.nextLong();
        W = sc.nextLong();
        S = sc.nextLong();

        long Alength = (X + Y) * W;

        long Blength = Math.min(X, Y) * S + (Math.abs(X-Y)* W);

        long Clength = Math.min(X, Y) * S;

        if((X+Y) % 2 == 0)
            Clength += Math.abs(X-Y) * S;
        else if((X+Y) % 2 == 1)
            Clength += (Math.abs(X-Y)-1) * S + W;

        System.out.println(Math.min(Clength,(Math.min(Alength, Blength))));
    }
}
