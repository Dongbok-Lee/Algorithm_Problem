import java.io.*;
import java.util.*;

class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long sum = 0;
    static int[] arr = new int[500001];
    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++)
            arr[Integer.parseInt(br.readLine())]++;

        int count = 1;
        for(int i = 1; i <= 500000; i++){
            if(arr[i] > 0){
                while(arr[i] != 0){
                    arr[i]--;
                    sum += Math.abs(i-count);
                    count++;
                }
            }
        }
        System.out.println(sum);
    }
}