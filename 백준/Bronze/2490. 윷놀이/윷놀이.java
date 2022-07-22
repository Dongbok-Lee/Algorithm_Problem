import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 3; i++) {
            int count = 0;
            for(int j = 0; j < 4; j++)
                if(sc.nextInt() == 1)
                    count++;

            switch(count){
                case 0:
                    System.out.println("D");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 4:
                    System.out.println("E");
                    break;
            }
        }
    }
}
