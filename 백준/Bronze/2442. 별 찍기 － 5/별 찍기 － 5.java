import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N-1; j++)
                System.out.print(" ");

            for(int j = i*2; j >= 0; j--)
                System.out.print("*");

            System.out.println();
        }
    }
}
