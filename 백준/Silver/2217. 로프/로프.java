import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, max = 0;

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();
        int[] rope = new int[N];

        for(int i = 0; i < N; i++)
            rope[i] = sc.nextInt();

        Arrays.sort(rope);

        for(int i = 0; i < N; i++)
            max = Math.max(rope[i]*(N-i), max);


        System.out.println(max);
    }
}
