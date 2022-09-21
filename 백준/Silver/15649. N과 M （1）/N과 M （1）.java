import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String[] ars) throws IOException {

        N = sc.nextInt();
        M = sc.nextInt();


        recursion(0,0);
    }

    static void recursion(int n, int m){
        if(n == M){
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }



        for(int i = 1; i <= N; i++){
            arr[n] = i;
            if(visited[i] == false){
                visited[i] = true;
                recursion(n+1,i);
                visited[i] = false;
            }
        }

    }
}
