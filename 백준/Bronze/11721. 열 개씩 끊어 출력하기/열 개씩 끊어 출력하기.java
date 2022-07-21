import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] ars) throws IOException {
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++) {
            if(i%10 == 0 && i >= 10){
                System.out.println();
            }
            System.out.print(str.charAt(i));
        }
    }
}
