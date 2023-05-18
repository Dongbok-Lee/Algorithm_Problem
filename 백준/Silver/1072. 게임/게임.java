import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long X, Y;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        long result;
        long Z = 100 * Y / X;

        if(Z >= 99){
            System.out.println(-1);
            return;
        }
        
        result = ((Z + 1) * X - 100 * Y) / (99 - Z);
        if(((Z + 1) * X - 100 * Y)  % (99 - Z) != 0){
            result++;
        }

        System.out.println(result);
    }
}