import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, maxCount, number;

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {

            int count = 0;
            int x = N;
            int y = i;

            while(true){
                count++;
                int tmp = x;
                x = y;
                y = tmp - y;

                if( y < 0)
                    break;
            }

            maxCount = Math.max(maxCount,count);

            if(maxCount == count)
                number = i;

        }

        System.out.println(maxCount+1);

        int x = N;
        int y = number;

        while(true){
            System.out.print(x + " ");
            int tmp = x;
            x = y;
            y = tmp - y;

            if( y < 0){
                System.out.print(x + " ");
                break;
            }

        }
    }
}
