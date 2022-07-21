import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int num;

    public static void main(String[] ars) throws IOException {
        num = sc.nextInt();
        int count = 0;
        for(int i = 0; i < 5; i++)
            if(sc.nextInt() == num)
                count++;
        System.out.println(count);

    }
}
