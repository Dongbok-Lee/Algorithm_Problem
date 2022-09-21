import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;

    public static void main(String[] ars) throws IOException {

        T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int min = 101, max = 0;
            for(int j = 0; j < N; j++){
                int store = sc.nextInt();
                min = Math.min(min,store);
                max = Math.max(max,store);
            }
            System.out.println((max - min) * 2);
        }
    }
}
