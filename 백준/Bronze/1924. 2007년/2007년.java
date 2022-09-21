import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M ,D;
    static int[] month = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] ars) throws IOException {

        M = sc.nextInt();
        D = sc.nextInt();
        int sum = D;
        for(int i = 0; i < M; i++){
            sum += month[i];
        }

        switch(sum%7){
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }

    }
}
