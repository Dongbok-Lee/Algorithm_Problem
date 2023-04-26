import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        int n4 = Integer.parseInt(st.nextToken());

        int input = Math.min(makeNum(n1, n2, n3, n4), Math.min(makeNum(n2, n3, n4, n1), Math.min(makeNum(n3, n4, n1, n2), makeNum(n4, n1, n2, n3))));

        int cnt = 0;

        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                for(int k = 1; k < 10; k++){
                    for(int l = 1; l < 10; l++){
                        int min = Math.min(makeNum(l, i, j, k), Math.min(makeNum(k, l, i, j), Math.min(makeNum(i, j, k, l), makeNum(j, k, l, i))));
                        if(min == makeNum(i,j,k,l)){
                            cnt++;
                        }
                        if(min == input){
                            System.out.println(cnt);
                            return;
                        }
                    }
                }
            }
        }
    }

    static int makeNum(int num1, int num2, int num3, int num4) {
        return 1000 * num1 + 100 * num2 + 10 * num3 + num4;
    }

}