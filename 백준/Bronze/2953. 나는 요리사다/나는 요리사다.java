import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int max = 0;
    static int winner;
    public static void main(String[] ars) throws IOException {

        for(int i = 0; i < 5; i++) {

            int sum = 0;

            for(int j = 0; j < 4; j++)
                sum += sc.nextInt();

            if(sum > max){
                max = sum;
                winner = i + 1;
            }
        }
        System.out.println(winner + " " + max);
    }
}
