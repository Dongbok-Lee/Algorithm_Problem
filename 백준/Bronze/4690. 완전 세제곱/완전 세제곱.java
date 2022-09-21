import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] ars) throws IOException {
        for(int d = 6; d <= 100; d++)
            for(int c = 2; c <= d; c++)
                for(int b = c; b <= d; b++)
                    for(int a = b; a <=d; a++)
                        if(Math.pow(d,3) == Math.pow(c,3)+Math.pow(b,3)+Math.pow(a,3))
                            System.out.println("Cube = "+ d +", Triple = ("+ c+","+ b +","+a+")");
    }
}
