import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static long N, S = 0;
    public static void main(String[] ars) throws IOException {
        N = sc.nextLong();
        int count = 1;
        while(S <= N){
            S += count;
            count++;
        }
        System.out.println(count-2);
    }
}
