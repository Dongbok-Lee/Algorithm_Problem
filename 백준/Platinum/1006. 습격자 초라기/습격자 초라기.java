import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, W, result;
    static int a[] = new int[10001];
    static int b[] = new int[10001];
    static int c[] = new int[10001];
    static int circleMap[][] = new int[2][10001];

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            result = 987672364;
            circleMap = new int[2][10001];
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            a = new int[N];
            b = new int[N];
            c = new int[N+1];


            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k < N; k++)
                    circleMap[j][k] = Integer.parseInt(st.nextToken());
            }
            
            a[0] = 1;
            b[0] = 1;
            c[0] = 0;
            
            solve(0);

            result = Math.min(result, c[N]);

            if(N > 1){
                if(circleMap[0][0] + circleMap[0][N-1] <= W && circleMap[1][0] + circleMap[1][N-1] <= W){
                    a[1] = 1;
                    b[1] = 1;
                    c[1] = 0;

                    solve(1);

                    result = Math.min(result, c[N - 1] + 2);
                }

                if(circleMap[0][0] + circleMap[0][N-1] <= W){
                    a[1] = 2;
                    b[1] = circleMap[1][0] + circleMap[1][1] > W ? 2 : 1;
                    c[1] = 1;

                    solve(1);

                    result = Math.min(result, b[N-1] + 1);
                }

                if(circleMap[1][0] + circleMap[1][N-1] <= W){
                    a[1] = circleMap[0][0] + circleMap[0][1] > W ? 2 : 1;
                    b[1] = 2;
                    c[1] = 1;

                    solve(1);

                    result = Math.min(result, a[N-1] + 1);
                }
            }

            System.out.println(result);
        }
    }

    static void solve(int n){

        for(int i = n; i < N; i++){
            c[i + 1] = Math.min(a[i]+1 ,b[i] + 1);

            if(circleMap[0][i] + circleMap[1][i] <= W)
                c[i+1] = Math.min(c[i + 1], c[i] + 1);

            if(i > 0 && circleMap[0][i -1] + circleMap[0][i] <= W && circleMap[1][i - 1] + circleMap[1][i] <= W)
                c[i + 1] = Math.min(c[i + 1], c[i - 1] + 2);

            if(i < N - 1){
                a[i + 1] = c[i + 1] + 1;
                b[i + 1] = c[i + 1] + 1;

                if(circleMap[0][i] + circleMap[0][i + 1] <= W)
                    a[i + 1] = Math.min(a[i + 1], b[i] + 1);

                if(circleMap[1][i] + circleMap[1][i+1] <= W)
                    b[i + 1] = Math.min(b[i + 1], a[i] + 1);
            }
        }
    }

}
