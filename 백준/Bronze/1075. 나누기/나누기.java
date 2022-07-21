import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, F;

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();
        F = sc.nextInt();

        N /= 100;
        N *= 100;
        for(int i = 0; i < 100; i++) {
            if((N + i)%F == 0){
                System.out.println(String.format("%02d", i));
                return;
            }
        }
    }
}
