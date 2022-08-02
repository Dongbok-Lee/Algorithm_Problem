import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] parent = new int[1000001];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++)
            parent[i] = i;


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(reader.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0)
                union(a,b);
            else
                writer.write(isSameParent(a, b) ? "YES\n" : "NO\n");

        }
        writer.flush();
        writer.close();

    }

    static int find(int x){
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y)
            if(x > y)
                parent[y] = x;
            else
                parent[x] = y;
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

