import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int T,N,D;

    public static void main(String[] ars){
        T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int count = 0;
            N = sc.nextInt();
            D = sc.nextInt();

            for(int j = 0; j < N; j++){
                double V = sc.nextInt();
                double F = sc.nextInt();
                double C = sc.nextInt();

                if(V*(F/C) >= D)
                    count++;
            }
            System.out.println(count);
        }
    }
}
