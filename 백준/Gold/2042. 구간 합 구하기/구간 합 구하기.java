import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] arr, tree;
    static int N, M, K;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for(int i = 1; i <= N; i++)
            arr[i] = Long.parseLong(br.readLine());

        tree = new long[N * 4];

        init(1, N, 1);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());

            long c = Long.parseLong(st.nextToken());

            if( a == 1){
                long dif = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, dif);
            } else if( a == 2){
                System.out.println(sum(1, N, 1, b, (int)c));
            }
        }
    }

    public static long init(int start, int end, int node){
        if(start == end)
            return tree[node] = arr[start];

        int mid = (start + end)/2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static void update(int start, int end, int node, int index, long dif){

        if(index < start || index > end){
            return;
        }

        tree[node] += dif;
        if(start == end){
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }

    public static long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start)
            return 0;

        if(left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

}