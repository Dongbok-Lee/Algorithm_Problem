import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] ars) throws IOException {
        N = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        String[] arr = input.split(" ");
        long[] numbers = new long[N];
        long sum = 0;

        numbers[0] = Long.parseLong(arr[0]);

        for(int i = 1; i < N; i++) {
            numbers[i] = numbers[i-1] + Long.parseLong(arr[i]);
        }

        for(int i = N-2; i >= 0; i--) {
            sum += Long.parseLong(arr[i+1]) * numbers[i];
        }

        System.out.println(sum);
    }
}
