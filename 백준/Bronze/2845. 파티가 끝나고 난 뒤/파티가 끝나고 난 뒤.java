import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, P;

    public static void main(String[] ars) throws IOException {
        L = sc.nextInt();
        P = sc.nextInt();
        int num = L * P;

        for(int i = 0; i < 5; i++){
            System.out.print((sc.nextInt()-num)+" ");
        }

    }
}
