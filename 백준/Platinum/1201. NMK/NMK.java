import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N, M, K;
    static int[] arr = new int[501];
    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        if(N < M+K-1 || N > M*K){
            System.out.println(-1);
            return;
        }

        for(int i = 1; i <= 500; i++)
            arr[i] = i;

        reverse(1, K);

        int start, end = K;

        if(M == 1){
            for(int i = 1; i <= N; i++)
                System.out.print(arr[i] + " ");
            return;
        }

        int tmp = (N - K) / (M - 1);
        int remain = (N - K) % (M - 1);

        for(int i = 0; i < M-1; i++){
            start = end+1;
            end += tmp;

            if(remain > 0){
                remain--;
                end++;
                reverse(start,end);
            }
            else
                reverse(start,end);
        }


        for(int i = 1; i <= N; i++)
            System.out.print(arr[i] + " ");
    }

    static void reverse(int x, int y){
        while(x < y){
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
            x++;
            y--;
        }
    }

}

