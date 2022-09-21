import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] sorted = new int[5];
    static int sum = 0;

    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 5; i++){
            sorted[i] = sc.nextInt();
            sum += sorted[i];
        }

        Arrays.sort(sorted);

        System.out.println(sum/5);
        System.out.println(sorted[2]);

    }
}
