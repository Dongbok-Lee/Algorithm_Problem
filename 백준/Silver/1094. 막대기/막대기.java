import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int X;

    public static void main(String[] ars) throws IOException {
        X = sc.nextInt();
        int length = 64;
        int cur = 0;
        int count= 0;
        while (cur != X){
            if(length > X){
                length /= 2;
                continue;
            }

            if(cur + length <= X){
                cur += length;
                count++;
            }
            else{
                length /= 2;
            }
        }

        System.out.println(count);
    }
}
