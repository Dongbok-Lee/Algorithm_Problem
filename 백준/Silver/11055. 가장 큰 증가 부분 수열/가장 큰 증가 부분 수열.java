import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, result = 0;
    static int[] sum = new int[1001];

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            int num = sc.nextInt();

            for(int j = 0; j < num; j++)
                sum[num] = Math.max(sum[num], sum[j] + num);

            result = Math.max(result, sum[num]);
        }


        System.out.println(result);

    }
}
