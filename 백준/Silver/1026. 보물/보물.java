import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, result = 0;

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        for(int i = 0; i < N; i++)
            B[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < N; i++)
            result += A[i]* B[N-i-1];

        System.out.println(result);

    }
}
