import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;

    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int[] numbers = new int[7];
            int min = 100;
            int sum = 0;

            for(int j = 0; j < 7; j++)
                numbers[j] = sc.nextInt();

            for(int j = 0; j < 7; j++)
                if(numbers[j] % 2 == 0){
                    min = Math.min(min, numbers[j]);
                    sum += numbers[j];
                }
            System.out.println(sum +" " + min);


        }

    }
}
