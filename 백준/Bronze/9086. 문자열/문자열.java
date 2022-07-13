import java.util.*;

public class Main {

    static HashMap<String, Double> map = new HashMap<String, Double>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] ars) {
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            String str = sc.next();
            System.out.print((char)str.charAt(0));
            System.out.print((char)str.charAt(str.length()-1));
            System.out.println();
        }
    }
}