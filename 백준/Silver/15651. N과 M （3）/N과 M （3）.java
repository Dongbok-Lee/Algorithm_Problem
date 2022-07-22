import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr = new int[8];
    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();
        M = sc.nextInt();

        recursion(0);
        writer.flush();
        writer.close();
    }

    static void recursion(int index) throws IOException {
        if(index == M){
            for(int i = 0; i < M; i++)
                writer.write(arr[i] + " ");
            writer.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[index] = i;
            recursion(index +1);
        }
    }

}
