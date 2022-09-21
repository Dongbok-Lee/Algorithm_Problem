import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int[] dice = new int[7];
    static int max;

    public static void main(String[] ars) {
        for(int i = 0; i < 3; i++){
            int num = sc.nextInt();
            dice[num]++;
        }

        for(int i = 1; i < 7; i++){
            if(dice[i] == 1)
                max = i;
            if(dice[i] == 2){
                System.out.println(1000+i*100);
                return;
            }
            if(dice[i] == 3){
                System.out.println(10000+i*1000);
                return;
            }
        }
        System.out.println(max * 100);
    }
}

