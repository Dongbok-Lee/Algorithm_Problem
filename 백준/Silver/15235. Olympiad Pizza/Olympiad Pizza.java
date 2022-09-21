import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] count = new int[1001];
    static Queue<Node> q = new LinkedList<>();
    static int time = 0;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();

        for(int i = 0; i < N; i++){
            q.offer(new Node(sc.nextInt(), i));
        }

        while(!q.isEmpty()){
            time++;
            Node curNode = q.poll();
            curNode.count--;
            if(curNode.count == 0)
                count[curNode.person] = time;
            else
                q.offer(new Node(curNode.count, curNode.person));
        }

        for(int i = 0; i < N; i++)
            System.out.print(count[i] + " ");
    }




}

class Node{
    int count, person;

    public Node(int count, int person) {
        this.count = count;
        this.person = person;
    }
}


