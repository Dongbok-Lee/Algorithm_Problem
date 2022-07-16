import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static double area;
    static double PI = 3.141592653589793;

    public static void main(String[] ars) {
        area = sc.nextDouble();
        System.out.println(Math.sqrt(area/PI)*2*PI);
    }
}
