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
            boolean[] entry = new boolean[501];
            int N = sc.nextInt();
            int M = sc.nextInt();
            int counter = 0;
            for(int j = 0; j < N; j++){
                int k = sc.nextInt();
                if(entry[k] == false)
                    entry[k] = true;
                else
                    counter++;
            }

            System.out.println(counter);
        }
    }
}
