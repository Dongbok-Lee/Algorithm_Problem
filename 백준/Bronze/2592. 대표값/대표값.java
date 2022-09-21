import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int sum = 0, max = 0, index;
    static int[] arr = new int[100];

    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 10; i++){
            int tmp = sc.nextInt();

            sum += tmp;
            arr[(tmp/10)]++;
        }

        System.out.println(sum/10);

        for(int i = 0; i < 100; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }

        }

        System.out.println(index*10);
    }
}
