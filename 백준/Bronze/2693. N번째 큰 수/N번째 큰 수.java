import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] sorted = new int[10];
    static int T;

    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();

        for(int i = 0; i < T; i++){
            for(int j = 0; j < 10; j++)
                sorted[j] = sc.nextInt();

            Arrays.sort(sorted);

            System.out.println(sorted[7]);
        }
    }
}
