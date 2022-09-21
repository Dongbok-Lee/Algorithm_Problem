import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static boolean[] arr = new boolean[2001];

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            arr[tmp+1000] = true;
        }

        for(int i = 0; i < 2001; i++)
            if(arr[i] == true)
                System.out.print((i-1000)+" ");

    }
}
