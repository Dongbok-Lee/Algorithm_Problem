import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{

        while(true){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for(int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){
                return;
            }

            if(arr[2] >= arr[0] + arr[1]){
                System.out.println("Invalid");
                continue;
            }

            if(arr[0] == arr[1] &&  arr[1] == arr[2]){
                System.out.println("Equilateral");
            }else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]){
                System.out.println("Isosceles");
            }else{
                System.out.println("Scalene");
            }
        }
    }
}