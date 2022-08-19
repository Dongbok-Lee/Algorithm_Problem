import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int arr[] = new int[10001];
    static int arr2[] = new int[10001];
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr2, 0, N);

        int tmp = arr2[0];
        for(int i = 1; i < N; i++){
            int tmp2 = arr2[i];
            arr[i-1] = tmp2 - tmp;
            tmp = tmp2;
        }

        Arrays.sort(arr,0, N-1);


        int sum = 0;

        for(int i = 0; i < N - K; i++)
            sum += arr[i];

        System.out.println(sum);
    }
}
