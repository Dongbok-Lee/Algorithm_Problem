import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int max = 0, min = 101;
    static int result = 0;
    static int[] hills = new int[1001];
    static int[] modified_hills = new int[1001];

    public static void main(String[] ars){
        N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int tmp = sc.nextInt();
            hills[i] = tmp;
            modified_hills[i] = tmp;
            max = Math.max(hills[i],max);
            min = Math.min(hills[i],min);
        }
        while(max - min >17){
            int decrease = 0, increase = 0;

            for(int i = 0; i < N; i++){
                if(modified_hills[i] == max){
                    decrease+=Math.pow(hills[i]-max+1,2);
                    increase+=Math.pow(hills[i]-max,2);

                }
                if(modified_hills[i] == min){
                    increase+=Math.pow(min-hills[i]+1,2);
                    decrease+=Math.pow(min-hills[i],2);
                }
            }

            if(decrease <= increase){
                for(int i = 0; i < N; i++){
                    if(modified_hills[i] == max)
                        modified_hills[i] = max -1;
                }
                max--;
            }

            if(decrease > increase){
                for(int i = 0; i < N; i++){
                    if(modified_hills[i] == min)
                        modified_hills[i] = min +1;
                }
                min++;
            }
        }

        for(int i = 0; i < N; i++)
            result += Math.pow(Math.abs(modified_hills[i] - hills[i]),2);

        System.out.println(result);
    }
}
