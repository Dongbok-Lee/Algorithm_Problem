import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int result = 0;
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 5; i++)
            result += sc.nextInt();
        System.out.println(result);
    }
}