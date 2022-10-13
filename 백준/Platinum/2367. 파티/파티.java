import java.util.*;
import java.io.*;

public class Main{

    static Scanner sc = new Scanner(System.in);

    static int capacity[][] = new int[302][302];
    static int flow[][] = new int[302][302];
    static int parent[] = new int[302];
    static int N, K, D, sink, totalFlow = 0, source = 0;

    public static void main(String[] args) throws Exception{

        for(int i = 0 ; i < 302; i++)
            Arrays.fill(capacity[i], 0);

        N = sc.nextInt();
        K = sc.nextInt();
        D = sc.nextInt();

        sink = N + D + 1;

        for(int i = 1; i <= D; i++)
            capacity[N+i][sink] = sc.nextInt();

        for(int i = 1; i <= N; i++){
            int dish = sc.nextInt();
            capacity[source][i] = K;
            for(int j = 0; j < dish; j++)
                capacity[i][N+sc.nextInt()] = 1;
        }

        while(true){
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            parent[source] = source;

            while(!q.isEmpty() && parent[sink] == -1){

                int cur = q.poll();

                for(int i = 0; i < 302; i++){
                    if(capacity[cur][i] > flow[cur][i] && parent[i] == -1){
                        q.offer(i);
                        parent[i] = cur;
                    }
                }
            }

            if(parent[sink] == -1)
                break;

            int amount = 987654321;

            for(int i = sink; i != source; i = parent[i])
                amount = Math.min(amount, capacity[parent[i]][i] - flow[parent[i]][i]);

            for(int i = sink; i != source; i = parent[i]){
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }

            totalFlow += amount;
        }

        System.out.println(totalFlow);
    }
}