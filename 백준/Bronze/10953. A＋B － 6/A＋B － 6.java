import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            System.out.println((int)s.toCharArray()[0]-48 +(int)s.toCharArray()[2]-48);
        }
    }
}