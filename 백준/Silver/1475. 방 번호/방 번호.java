import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static String arr;
    static int[] set = new int[10];
    static int result = 0;
    public static void main(String[] ars) throws IOException {
            arr = sc.nextLine();

            for(char c : arr.toCharArray()) {
                int tmp = c- '0';
                set[tmp]++;
            }

            for(int i = 0; i < 9; i++) {
                if(i == 6){
                    result = Math.max(result, (set[6] + set[9]+1)/2);
                    continue;
                }
                result = Math.max(result, set[i]);
            }

        System.out.println(result);
        }
}
