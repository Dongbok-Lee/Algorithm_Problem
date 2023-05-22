import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, result = 0;
    static char[] charArr;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        charArr = br.readLine().toCharArray();
        boolean[] chkArr = new boolean[charArr.length];

        for(int i = 0; i < charArr.length; i++){

            if(charArr[i] == 'P'){
                for(int j = i - K; j <= i + K; j++){
                    if(isInside(j) && charArr[j] == 'H' && !chkArr[j]){
                        result++;
                        chkArr[j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static boolean isInside(int x){
        return x >= 0 && x < charArr.length;
    }
}