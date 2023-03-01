import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final long DIV = 1000000007;

    static int N, M, K;
    static long[] arr, tree;


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        tree = new long[N * 4];

        init(1, N, 1);

        for(int i = 0; i < M + K; i++){

            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("1")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long diff = b - arr[a];
                arr[a] = b;

                update(1, N, 1, a, diff);

            }else{
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                System.out.println(multi(1, N, 1, a, b));
            }
        }



    }

    static long init(int start,int end, int node ){

        if(start == end)
            return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % DIV;
    }

    static long update(int start, int end, int node, int index, long diff){
        if(index < start || index > end)
            return tree[node];

        if(start == end)
            return tree[node] += diff;

        int mid = (start + end) / 2;

        return tree[node] = (update(start, mid, node * 2, index, diff) * update(mid + 1, end, node * 2 + 1, index, diff)) % DIV;

    }

    static long multi(int start, int end, int node, int left, int right){

        if(left > end || right < start)
            return 1;

        if(start >= left &&  end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        return multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 + 1, left, right) % DIV;

    }

}