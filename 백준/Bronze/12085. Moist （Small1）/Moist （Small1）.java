import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N,T;
    public static void main(String[] ars) {
        T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int result = 0;
            N = sc.nextInt();
            sc.nextLine();
            String max = sc.nextLine();
            for(int j = 1; j < N; j++) {
                String str = sc.nextLine();
                if(max.compareTo(str) >= 0){
                    result++;
                }
                else{
                    max = str;
                }
            }

            System.out.println("Case #"+(i+1) +": " + result);
        }

    }
}
