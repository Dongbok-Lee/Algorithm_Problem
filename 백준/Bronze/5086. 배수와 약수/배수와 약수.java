import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int A, B;
    static String result;

    public static void main(String[] ars) throws IOException {
        while(true){
            A = sc.nextInt();
            B = sc.nextInt();

            if(A == 0 && B == 0)
                break;

            if( A > B && A % B == 0){
                System.out.println("multiple");
                continue;
            }
            if( B > A && B % A == 0){
                System.out.println("factor");
                continue;
            }

            System.out.println("neither");

        }

    }
}
