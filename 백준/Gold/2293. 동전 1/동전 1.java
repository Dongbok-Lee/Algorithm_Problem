import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] count = new int[100000];

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();
        K = sc.nextInt();
        int[] arr = new int[N];
        count[0] = 1;

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = arr[i]; j <= K; j++)
                count[j] += count[j-arr[i]];


        System.out.println(count[K]);

    }
}
