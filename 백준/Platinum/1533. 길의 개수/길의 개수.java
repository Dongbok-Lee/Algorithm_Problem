import java.util.Scanner;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static long[][] array;
    static long[][] ans;
    static int N, S, E, T;

    static final int MOD = 1000003;
    public static void main(String[] args) {

        N = sc.nextInt();
        S = sc.nextInt();
        E = sc.nextInt();
        T = sc.nextInt();
        array = new long[(N * 5) + 1][(N * 5) + 1];
        sc.nextLine();

        for(int i = 1; i <= N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) != '0') {
                    array[i * 5][(j + 1) * 5 - (s.charAt(j) - '0' - 1)] = 1;
                }
            }

            for(int j = 1; j < 5; j++)
                array[(i - 1) * 5 + j][(i - 1) * 5 + j + 1] = 1;

        }

        System.out.println(powProcession(array,T)[5*S][5*E]);
    }

    public static long[][] squareProcession(long[][] a, long[][] b) {

        long[][] result = new long[N * 5 + 1][N * 5 + 1];

        for (int i = 1; i <= 5 * N; i++) {
            for (int j = 1; j <= 5 * N; j++) {
                for (int k = 1; k <= 5 * N; k++) {
                    result[i][j] += (a[i][k] * b[k][j]);
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    public static long[][] powProcession(long[][] a, int n){

        long[][] result = new long[N * 5 + 1][N * 5 + 1];
        for(int i = 1; i <= N * 5; i++) result[i][i] = 1;

        while(n != 0){

            if(n % 2 == 1)
                result = squareProcession(result, a);

            n /= 2;
            a = squareProcession(a,a);


        }

        return result;
    }

    public static void printArray(long[][] a){
        for(int i = 0; i <= N*5; i++){
            for(int j = 0; j <= N*5; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
