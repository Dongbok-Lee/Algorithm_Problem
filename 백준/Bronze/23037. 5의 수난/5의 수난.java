import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int result = 0;

    public static void main(String[] ars) {
        String num = sc.next();

        for(char i : num.toCharArray()){
            int mul = i-'0';
            int tmp = 1;
            for(int j = 0; j < 5; j++)
                tmp *= mul;
            result += tmp;
        }

        System.out.println(result);
    }
}

