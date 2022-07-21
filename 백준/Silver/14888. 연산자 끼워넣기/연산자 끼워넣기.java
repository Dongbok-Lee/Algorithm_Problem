import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, max = -2100000000, min = 2100000000;
    static int[] operator = new int[4];
    static int[] arr = new int[12];
    static int[] calc = new int[11];

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();


        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < 4; i++)
            operator[i] = sc.nextInt();


        recursion(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void recursion(int index){
        if(index == N-1){
            max = Math.max(max,calc());
            min = Math.min(min,calc());
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] != 0){
                operator[i]--;
                calc[index] = i;
                recursion(index+1);
                operator[i]++;
            }
        }
    }

    static int calc(){
        int result = arr[0];
        for(int i = 0; i < N-1; i++){
            if(calc[i] == 0)
                result += arr[i+1];
            else if(calc[i] == 1)
                result -= arr[i+1];
            else if(calc[i] == 2)
                result *= arr[i+1];
            else
                result /= arr[i+1];
        }
        return result;
    }
}
