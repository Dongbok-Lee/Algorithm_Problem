import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] tree, index;
    static int T, N, M;

    public static void main(String[] args) throws IOException{

        T = Integer.parseInt(br.readLine());

        while(T-- != 0){

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            tree = new int[(N + M - 1)* 4];
            index = new int[N + 1];

            for(int i = 1; i < N + 1; i++)
                index[i] = N - i + 1;

            initTree(1, 1, N + M - 1);

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= M; i++){
                int K = Integer.parseInt(st.nextToken());

                int answer = getValue(1, 1, N + M - 1, index[K], N + i);

                setValue(1, 1, N + M - 1, index[K], -1);

                index[K] = N + i;

                setValue(1, 1, N + M - 1, index[K], 1);


                sb.append(answer - 1 + " ");
            }
            sb.append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int initTree(int node, int left, int right){

        if(left == right){
            if(left > N)
                return tree[node] = 0;
            else{
                return tree[node] = 1;
            }
        }

        int mid = (left + right) / 2;

        return tree[node] = initTree(node * 2, left, mid) + initTree(node * 2 + 1, mid + 1, right);
    }

    static int getValue(int node, int left, int right, int low, int high){

        if(low <= left && right <= high)
            return tree[node];

        if(right < low || left > high){
            return 0;
        }

        int mid = (right + left) / 2;

        return getValue(node * 2, left, mid, low ,high) + getValue(node * 2 + 1, mid + 1, right, low, high);

    }

    static int setValue(int node, int left, int right, int value, int diff){

        if(value < left || value > right){
            return tree[node];
        }

        if(left == right)
            return tree[node] += diff;

        int mid = (left + right) / 2;

        return tree[node] = setValue(node * 2, left, mid, value, diff) + setValue(node * 2 + 1, mid + 1, right, value, diff);
    }
}