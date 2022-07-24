import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int A, B;

    public static void main(String[] ars) throws IOException {
        A = sc.nextInt();
        B = sc.nextInt();
        int sum = 0;
        int count = 0;
        int Asum = 0, Bsum = 0;
        for(int i = 1; i < 1000; i++){

            for(int j = 1; j <= i; j++ ){
                sum += i;
                count ++;
                if(count == A-1){
                    Asum = sum;
                }
                if(count == B){
                    Bsum = sum;
                    System.out.println(Bsum - Asum);
                    return;
                }
            }

        }
    }
}
