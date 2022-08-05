import java.io.*;
import java.util.*;
import java.math.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       int min = 101;
       int sum = 0;

       for(int i = 0; i < 7; i++){
           int num = sc.nextInt();
           if(num % 2 == 1){
               sum+= num;
               min = Math.min(min , num);
           }
       }

       if(sum != 0){
           System.out.println(sum);
           System.out.println(min);
       }
       else
           System.out.println(-1);
    }
}

