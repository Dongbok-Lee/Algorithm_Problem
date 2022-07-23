import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ridePeople = 0;
    static int max = 0;

    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 4; i++){
            ridePeople -= sc.nextInt();
            ridePeople += sc.nextInt();

            max = Math.max(max, ridePeople);
        }

        System.out.println(max);
    }
}
