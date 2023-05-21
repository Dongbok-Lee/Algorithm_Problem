import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static boolean isFinish = false;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        dfs(0);

        for(int i : arr)
            System.out.print(i);


    }

    static void dfs(int index){

        if(index == N){
            isFinish = true;
            return;
        }

        for(int i = 1; i <= 3; i++){
            arr[index] = i;
            if(checkIsGoodArray(index)){
                dfs(index + 1);
            }

            if(isFinish)
                return;
        }
    }

    static boolean checkIsGoodArray(int index){
        for(int i = (index + 1) % 2; i < index; i += 2){

            for(int j = i; j <= i + (index - i) / 2; j++){
                if(arr[j] != arr[(i + (index - i) / 2 + 1 + (j - i))]){
                    break;
                }

                if(j == i + (index - i) / 2){
                    return false;
                }
            }
        }

        return true;
    }
}