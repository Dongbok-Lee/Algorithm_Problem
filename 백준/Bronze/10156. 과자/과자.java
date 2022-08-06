import java.io.*;
import java.util.*;
import java.math.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int a ,b ,c;
        a= sc.nextInt();
        b= sc.nextInt();
        c= sc.nextInt();

        if(a*b <= c)
            System.out.println(0);
        else
            System.out.println(a*b-c);
    }
}