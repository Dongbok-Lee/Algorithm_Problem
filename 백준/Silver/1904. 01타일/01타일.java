import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] fibonacci = new int[1000001];
    static int N;

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i = 2; i <= N; i++)
            fibonacci[i] = (fibonacci[i -1] + fibonacci[i-2])%15746;

        System.out.println(fibonacci[N]);

    }
}
