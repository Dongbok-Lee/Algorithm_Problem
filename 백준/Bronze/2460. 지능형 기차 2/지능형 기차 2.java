import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ridePeople = 0, maxPeople = 0;
    public static void main(String[] ars) throws IOException {

        for(int i = 0; i < 10; i++){
            ridePeople -= sc.nextInt();
            ridePeople += sc.nextInt();

            maxPeople = Math.max(maxPeople,ridePeople);
        }
        System.out.println(maxPeople);
    }
}
