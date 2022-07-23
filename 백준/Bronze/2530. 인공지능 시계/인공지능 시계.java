import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] ars) throws IOException {
        int curHour = sc.nextInt();
        int curMinute = sc.nextInt();
        int curSecond = sc.nextInt();

        int cookTime = sc.nextInt();
        int curTime = curHour*3600 + curMinute*60 + curSecond + cookTime;

        System.out.println((curTime/3600)%24 + " " + (curTime/60)%60 + " " + curTime%60);
    }
}
