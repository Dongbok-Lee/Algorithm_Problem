import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int count = 0;
    static String str, str2;

    public static void main(String[] ars) {
        N = sc.nextInt();
        sc.nextLine();

        str = sc.nextLine();
        str2 = sc.nextLine();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str2.charAt(i))
                count++;
        }
        System.out.println(count);
    }
}
