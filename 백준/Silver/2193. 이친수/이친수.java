import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long[] one = new long[91];
    static long[] zero = new long[91];
    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();

        one[1] = 1;
        zero[1] = 0;
        one[2] = 0;
        zero[2] = 1;
        one[3] = 1;
        zero[3] = 1;

        for(int i = 4; i <= N; i++) {
            one[i] = zero[i-1];
            zero[i] = zero[i-1] + one[i-1];
        }

        System.out.println((one[N]+zero[N]));
    }
}
