import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int index = sc.nextInt();
            String word = sc.next();

            for(int j = 0; j < word.length(); j++) {
                if(j != index-1)
                    System.out.print(word.charAt(j));
            }
            System.out.println();
        }
    }
}
