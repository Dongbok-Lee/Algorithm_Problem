import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static String num;
    public static void main(String[] ars) throws IOException {
        num = sc.nextLine();

        System.out.println(Integer.parseInt(num,16));

    }
}