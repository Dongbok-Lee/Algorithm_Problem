import java.io.*;
import java.util.*;

public class Main{

    static final int INF = 987654321;
    static int N;
    static Scanner sc = new Scanner(System.in);

    public static int atoi(char c){
        if('A' <= c && c <= 'Z') return (c - 64);
        else if('a' <= c && c <= 'z') return (c - 70);
        return 0;
    }


    public static void main(String[] args) throws Exception{
        N = sc.nextInt();
        int capacity[][] = new int[53][53], flow[][] = new int[53][53];

        while (N-- > 0){
            int from = atoi(sc.next().charAt(0));
            int to = atoi(sc.next().charAt(0));
            capacity[to][from] = capacity[from][to] += sc.nextInt();
        }

        int source = 1, sink = 26;

        for(int i = 0; i < 53; i++)
            Arrays.fill(flow[i], 0);

        int totalFlow = 0;

        while(true){
            int[] parent = new int[53];
            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();

            parent[source] = source;
            q.add(source);

            while(!q.isEmpty() && parent[sink] == -1){
                int here = q.poll();
                for(int there = 0; there < 53; there++){
                    if(capacity[here][there] - flow[here][there] > 0 && parent[there] == -1){
                        q.add(there);
                        parent[there] = here;
                    }
                }
            }

            if(parent[sink] == -1)
                break;

            int amount = INF;

            for(int p = sink; p != source; p = parent[p]){
                amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);
            }

            for(int p = sink; p != source; p = parent[p]){
                flow[parent[p]][p] += amount;
                flow[p][parent[p]] -= amount;
            }

            totalFlow += amount;
        }
        System.out.println(totalFlow);
    }
}