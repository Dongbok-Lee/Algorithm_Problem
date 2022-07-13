import java.util.*;

public class Main {

    static int[][] A = new int[101][101];
    static int[][] B = new int[101][101];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] ars) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                A[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                B[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(A[i][j] + B[i][j] +" ");
            }
            System.out.print("\n");
        }
    }
}

