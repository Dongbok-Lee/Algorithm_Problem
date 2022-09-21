import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int money;
    static int result = 0;

    public static void main(String[] ars) throws IOException {
        money = 1000- sc.nextInt();
        result += money/500;
        result += (money%500)/100;
        result += (money%100)/50;
        result += (money%50)/10;
        result += (money%10)/5;
        result += money%5;

        System.out.println(result);
    }
}
