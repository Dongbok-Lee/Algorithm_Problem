import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int W;
    static int H;
    public static void main(String[] ars) {
        N = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        double MAX = Math.sqrt(W*W + H*H);

        for(int i = 0; i < N; i++) {
            int length = sc.nextInt();
            if(length > MAX)
                System.out.println("NE");
            else
                System.out.println("DA");
        }
    }
}

