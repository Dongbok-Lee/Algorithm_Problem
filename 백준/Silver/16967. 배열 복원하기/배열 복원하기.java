import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int H, W, X, Y;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        arr = new int[H + X][W + Y];

        for(int i = 0; i < H + X; i++){

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < W + Y; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < H - X; i++){
            for(int j = 0; j < W - Y; j++){
                arr[i + X][j + Y] -= arr[i][j];
            }
        }

        printArr();
    }

    static void printArr(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}