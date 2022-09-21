import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, N;
    static boolean[] diver = new boolean[10001];


    public static void main(String[] ars) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            diver[Integer.parseInt(st.nextToken())] = true;

        if( R == N)
            System.out.println("*");
        else{
            for(int i = 1; i <= R; i++)
                if(diver[i] == false)
                    System.out.print(i + " ");
        }
    }
}