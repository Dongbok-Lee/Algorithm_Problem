import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, max = 0, min = 987654321;

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            max = Math.max(max,tmp);
            min = Math.min(min,tmp);
        }

        System.out.println(max * min);
    }
}
