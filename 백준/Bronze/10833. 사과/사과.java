import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N, result;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();

        for(int i = 0; i < N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            result += b % a;
        }

        System.out.println(result);
    }
}


