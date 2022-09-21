import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    static StringTokenizer st;
    static int N, M;
    static int subjectList[] = new int[101];


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int P, L;
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Integer[] tmp = new Integer[101];
            for(int k = 0; k < 101; k++)
                tmp[k] = 0;
            for(int j = 0; j < P; j++)
                tmp[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(tmp, 0, P, Collections.reverseOrder());
            if(tmp[L-1] == 0)
                subjectList[i] = 1;
            else
                subjectList[i] = tmp[L-1];
        }

        Arrays.sort(subjectList,0,N);

        int result = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            result++;
            sum += subjectList[i];
            if(sum > M){
                result--;
                break;
            }
        }

        System.out.println(result);
    }
}



