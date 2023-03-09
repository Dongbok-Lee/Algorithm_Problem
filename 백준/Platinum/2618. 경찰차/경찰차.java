import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, W;
    static Node aNode, bNode;
    static Node[] event;
    static int arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        aNode = new Node(1, 1);
        bNode = new Node(N, N);

        arr = new int[W + 1][W + 1];
        event = new Node[W + 1];

        for(int i = 0; i < W + 1; i++)
            Arrays.fill(arr[i], -1);


        for(int i = 1; i <= W; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            event[i] = new Node(x, y);
        }

        System.out.println((getMaxDistance(0, 0)));
        findRoute(0,0);
        System.out.println(sb.toString());

    }

    static int getMaxDistance(int A, int B){

        if(A == W || B == W)
            return 0;

        if(arr[A][B] != -1)
            return arr[A][B];

        aNode = A == 0 ? new Node(1, 1): event[A];
        bNode = B == 0 ? new Node(N, N): event[B];

        int nextEventNum = Math.max(A, B) + 1;

        int distA = Math.abs(aNode.x - event[nextEventNum].x) + Math.abs(aNode.y - event[nextEventNum].y);
        int distB = Math.abs(bNode.x - event[nextEventNum].x) + Math.abs(bNode.y - event[nextEventNum].y);

        int resultA = getMaxDistance(A, nextEventNum) + distB;
        int resultB = getMaxDistance(nextEventNum, B) + distA;

        return arr[A][B] = Math.min(resultA, resultB);
    }

    static void findRoute(int A, int B){

        if(A == W || B == W)
            return;

        aNode = A == 0 ? new Node(1, 1): event[A];
        bNode = B == 0 ? new Node(N, N): event[B];

        int nextEventNum = Math.max(A, B) + 1;

        int distA = Math.abs(aNode.x - event[nextEventNum].x) + Math.abs(aNode.y - event[nextEventNum].y);
        int distB = Math.abs(bNode.x - event[nextEventNum].x) + Math.abs(bNode.y - event[nextEventNum].y);

        int resultA = arr[nextEventNum][B] + distA;
        int resultB = arr[A][nextEventNum] + distB;

        if(resultA > resultB){
            sb.append("2" + "\n");
            findRoute(A, nextEventNum);

        }else{
            sb.append("1" + "\n");
            findRoute(nextEventNum, B);

        }
    }
}

class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}