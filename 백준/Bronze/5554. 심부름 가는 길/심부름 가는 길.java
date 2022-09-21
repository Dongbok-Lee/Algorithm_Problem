import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        count += sc.nextInt();
        count += sc.nextInt();
        count += sc.nextInt();
        count += sc.nextInt();

        System.out.println(count/60);
        System.out.println(count%60);
    }


}
