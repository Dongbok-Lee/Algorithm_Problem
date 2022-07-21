import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] fibonacci = new int[50];
    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();

        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i <= N; i++)
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

        System.out.println(fibonacci[N]);
    }
}
