import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int J, R;
    static int[] player = new int[501];
    static int result = 0;
    static int winner;

    public static void main(String[] ars) {
        J = sc.nextInt();
        R = sc.nextInt();

        for(int i = 0; i < R; i++) {
            for(int j = 1; j <= J; j++) {
                player[j] += sc.nextInt();
            }
        }

        for(int i = 1; i <= J; i++) {
            if(player[i] == Math.max(result,player[i])){
                result = player[i];
                winner = i;
            }

        }

        System.out.println(winner);
    }
}