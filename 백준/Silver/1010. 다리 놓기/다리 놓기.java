import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N ,M;

    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();
        for(int i = 0; i < T; i++){
            N = sc.nextInt();
            M = sc.nextInt();

            double result = 1;

            for(int j = M; j > M-N; j--)
                result *= j;

            for(int j = 1; j <= N; j++)
                result /= j;

            System.out.printf("%.0f", result);
            System.out.println();

        }
    }
}
