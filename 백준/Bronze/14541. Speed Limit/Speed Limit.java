import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N = 0;

    public static void main(String[] ars){
        while(N != -1){
            int t = 0, s;
            int result = 0;
            int tmp;
            N = sc.nextInt();

            for(int i = 0; i < N; i++){
                tmp = t;
                s = sc.nextInt();
                t = sc.nextInt();

                result +=  s*(t-tmp);
            }
            if(N!= -1)
                System.out.println(result + " miles");
        }
    }
}
