import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;

    public static void main(String[] ars) throws IOException {

        T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int num = sc.nextInt();
            String binaryString = Integer.toBinaryString(num);

            for(int j = binaryString.length() - 1; j >= 0; j--){
                if(binaryString.charAt(j) == '1')
                    System.out.print(binaryString.length() - 1- j + " ");
            }
        }
    }
}
