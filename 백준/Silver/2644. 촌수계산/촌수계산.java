import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] parent = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {

        N = sc.nextInt();

        //부모자식
        int x = sc.nextInt();
        int y = sc.nextInt();

        M = sc.nextInt();

        for(int i = 1; i < N; i++)
            parent[i] = i;

        for(int i = 0; i < M; i++){
            int parentNum = sc.nextInt();
            int son = sc.nextInt();
            parent[son] = parentNum;
        }

        //bfs이용
        Queue q = new LinkedList<Node>();

        q.offer(new Node(x,0));
        visited[x] = true;

        while(!q.isEmpty()){
            Node curNode = (Node)q.peek();

            if(curNode.num == y){
                System.out.println(curNode.counter);
                return;
            }

            q.poll();

            if(!visited[parent[curNode.num]]){
                q.offer(new Node(parent[curNode.num],curNode.counter+1));
                visited[parent[curNode.num]] = true;
            }

            for(int i = 1; i <= N; i++)
                if(parent[i] == curNode.num && !visited[i]){
                    q.offer(new Node(i, curNode.counter + 1));
                    visited[i] = true;
                }
        }
        System.out.println(-1);
    }
}

class Node{
    int num;
    int counter;

    public Node(int num, int counter) {
        this.num = num;
        this.counter = counter;
    }
}
