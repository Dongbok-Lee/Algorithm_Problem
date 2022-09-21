import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] parent = new int[201];
    static int[] travelPlan = new int[1001];
    public static void main(String[] args) throws IOException {
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 1; i <= N; i++)
            parent[i] = i;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int tmp = sc.nextInt();

                if(tmp == 1)
                    union(i,j);
            }
        }

        for(int i = 0; i < M; i++)
            travelPlan[i] = sc.nextInt();


        for(int i = 0; i < M-1; i++){
            if(isSameParent(travelPlan[i],travelPlan[i+1]) == false){
                System.out.println("NO");
                return;
            }

            if(i == M-2)
                System.out.println("YES");
        }
    }

    static int find(int x){
        if(x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x != y)
            if(x < y)
                parent[x] = y;
            else
                parent[y] = x;
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y)
            return true;
        else
            return false;
    }
}


