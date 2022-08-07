import java.io.*;
import java.util.*;
import java.math.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, S ,R;
    static int[] kayak_num = new int[11];

    public static void main(String[] args) throws IOException {
        N = sc.nextInt();
        S = sc.nextInt();
        R = sc.nextInt();

        for(int i = 0; i < N; i++)
            kayak_num[i] = 1;

        for(int i = 0; i < S; i++)
            kayak_num[sc.nextInt()-1]--;

        for(int i = 0; i < R; i++)
            kayak_num[sc.nextInt()-1]++;

        for(int i = 0; i < N; i++){
            if(kayak_num[i] == 0){
                if(i-1 > 0 && kayak_num[i-1] == 2){
                    kayak_num[i]++;
                    kayak_num[i-1]--;
                }
                else if(i+1 < N && kayak_num[i+1] == 2){
                    kayak_num[i]++;
                    kayak_num[i+1]--;
                }

            }
        }
        int count = 0;

        for(int i = 0; i < N; i++)
            if(kayak_num[i] == 0)
                count++;

        System.out.println(count);
    }
}

