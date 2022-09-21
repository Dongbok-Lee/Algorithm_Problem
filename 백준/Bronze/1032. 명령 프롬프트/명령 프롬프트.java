import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static String[] arr = new String[51];

    public static void main(String[] args) throws IOException {
        N = sc.nextInt();
        String result = "";
        sc.nextLine();
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextLine();


        for(int i = 0; i < arr[0].length(); i++){
            char tmp = arr[0].charAt(i);
            for(int j = 0; j < N; j++){
                if(tmp != arr[j].charAt(i)){
                    result += "?";
                    break;
                }

                if(j == N-1)
                    result += tmp;
            }
        }

        System.out.println(result);
    }
}
