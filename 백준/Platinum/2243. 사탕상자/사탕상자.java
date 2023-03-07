import java.io.*;
import java.util.StringTokenizer;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] tree;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tree = new int[1000000 * 4];

        for(int i = 0; i < N; i++){

            int A, B, C;

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(A == 1){
                sb.append(getValue(1,1,1000000,B) + "\n");
            }else{
                C = Integer.parseInt(st.nextToken());
                addValue(1, 1, 1000000, B, C);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void addValue(int root, int start, int end,int value, int diff){

        if(start > value || end < value)
            return;

        tree[root] += diff;

        if(start == end)
            return;

        int mid = (start + end) / 2;

        addValue(root * 2, start, mid, value, diff);
        addValue(root * 2 + 1, mid + 1, end, value, diff);
    }

    static int getValue(int root, int start, int end, int rank){

        tree[root] --;

        if(start == end)
            return start;

        int mid = (start + end) / 2;

        if(tree[root * 2] < rank)
            return getValue(root * 2 + 1, mid + 1, end, rank - tree[root * 2]);
        else
            return getValue(root * 2, start, mid, rank);
    }

}
