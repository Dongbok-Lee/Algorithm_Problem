import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N, L;

    public static void main(String[] args) {
        N = sc.nextInt();
        L = sc.nextInt();
        Size[] pool = new Size[N];
        for(int i = 0; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            pool[i] = new Size(start, end);
        }

        int curLoc = 0, count = 0;

        Arrays.sort(pool,(s1,s2)->s1.start-s2.start);

        for(int i = 0; i < N; i++){
            Size curSize = pool[i];
            int poolSize = curSize.end - curSize.start;

            if(curSize.start < curLoc && curLoc < curSize.end)
                poolSize = curSize.end - curLoc;
            else if(curLoc >= curSize.end)
                continue;
            else
                curLoc = curSize.start;

            count += ((poolSize-1)/L+1);
            curLoc += L*((poolSize-1)/L+1);

        }
        System.out.println(count);
    }
}

class Size{
    public int start;
    public int end;

    public Size(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
