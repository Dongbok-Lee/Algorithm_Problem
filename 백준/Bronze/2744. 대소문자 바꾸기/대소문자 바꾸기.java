import java.util.*;

public class Main {

    static String word;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] ars) {
        word = sc.next();

        for(char ch: word.toCharArray()){
            if(ch >= 97)
                System.out.print((char)(ch - 32));
            if(ch <= 91)
                System.out.print((char)(ch + 32));
        }
    }
}

