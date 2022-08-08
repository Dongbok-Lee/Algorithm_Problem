import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] arr = {1,1,2,2,2,8};

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 6; i++)
            System.out.print(arr[i]-sc.nextInt()+ " ");
    }
}