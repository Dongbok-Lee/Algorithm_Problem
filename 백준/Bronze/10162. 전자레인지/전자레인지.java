import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T = 0;
    static int result = 0;

    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();

        if(T%10 != 0){
            System.out.println(-1);
            return;
        }

        int five = T/300;
        int min = (T%300)/60;
        int second = (T%60)/10;

        System.out.println(five + " " + min + " " + second);
    }
}
