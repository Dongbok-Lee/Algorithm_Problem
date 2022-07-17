import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int num = 0;

    public static void main(String[] ars) {
        while(true){
            int sum = 0;
            num = sc.nextInt();

            if(num == -1)
                return;

            for(int i = 1; i < num; i++){
                if(num % i == 0){
                    sum += i;
                }
            }

            if(sum != num)
                System.out.println(num +" is NOT perfect.");

            if(sum == num){
                System.out.print(num + " = " + 1);
                for(int i = 2; i < num; i++){
                    if(num % i == 0)
                    System.out.print(" + " + i);
                }
                System.out.println();
            }
        }
    }
}
