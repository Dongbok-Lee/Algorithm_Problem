import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static String arr;

    public static void main(String[] ars) throws IOException {
        arr = sc.nextLine();
        char[] chrArr = arr.toCharArray();

        Arrays.sort(chrArr);

        for(int i = chrArr.length - 1; i >= 0; i--)
            System.out.print(chrArr[i]);
    }
}
