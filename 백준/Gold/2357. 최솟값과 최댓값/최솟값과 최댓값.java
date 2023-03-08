import java.io.*;
import java.util.StringTokenizer;

class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] minTree, maxTree, arr;


    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        minTree = new int[N * 4];
        maxTree = new int[N * 4];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initMinTree(1, 1, N);
        initMaxTree(1, 1, N);

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getMinValueFromSection(1, 1, N, a, b) + " ");
            sb.append(getMaxValueFromSection(1, 1, N, a, b) + "\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int initMinTree(int root, int start, int end) {
        if(start == end)
            return minTree[root] = arr[start];

        int mid = (start + end) / 2;

        return minTree[root] = Math.min(initMinTree(root * 2, start, mid), initMinTree(root * 2 + 1, mid + 1, end));
    }

    static int initMaxTree(int root, int start, int end){
        if(start == end)
            return maxTree[root] = arr[start];

        int mid = (start + end) / 2;

        return maxTree[root] = Math.max(initMaxTree(root * 2, start, mid), initMaxTree(root * 2 + 1, mid + 1, end));
    }

    static int getMinValueFromSection(int root, int start, int end, int left, int right){

        if(left > end || right < start)
            return 2000000000;

        if(left <= start && right >= end)
            return minTree[root];

        int mid = (start + end) / 2;

        return Math.min(getMinValueFromSection(root * 2, start, mid, left, right) ,getMinValueFromSection(root * 2 + 1, mid + 1, end, left, right));
    }

    static int getMaxValueFromSection(int root, int start, int end, int left, int right){

        if(left > end || right < start)
            return 0;

        if(left <= start && right >= end)
            return maxTree[root];

        int mid = (start + end) / 2;

        return Math.max(getMaxValueFromSection(root * 2, start, mid, left, right), getMaxValueFromSection(root * 2 + 1, mid + 1, end, left, right));
    }
}