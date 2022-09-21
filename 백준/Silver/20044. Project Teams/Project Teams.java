import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int min = 987654321;

    public static void main(String[] args) {
        N = sc.nextInt();
        int[] arr = new int[2*N];
        for(int i = 0; i < 2*N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for(int i = 0; i < N; i++)
            min = Math.min(min, arr[i] + arr[2*N-1-i]);

        System.out.println(min);
    }
}