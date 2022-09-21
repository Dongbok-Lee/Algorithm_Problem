import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[3];

    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 3; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        for(int i = 0; i < 3; i++)
            System.out.print(arr[i]+ " ");

    }
}
