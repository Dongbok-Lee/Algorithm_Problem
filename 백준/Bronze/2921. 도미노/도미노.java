import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N, result;
    public static void main(String[] ars) {
        N = sc.nextInt();

        for(int i = 0; i <= N; i++){
            for(int j = i; j <= N; j++){
                result += i+j;
            }
        }

        System.out.println(result);
    }
}
