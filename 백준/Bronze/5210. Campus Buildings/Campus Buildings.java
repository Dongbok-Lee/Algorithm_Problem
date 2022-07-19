import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int T;
    static String[] arr = new String[101];
    public static void main(String[] ars) throws IOException {
        T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String word;
            int N = sc.nextInt();
            sc.nextLine();
            for(int j = 0; j < N; j++){
                arr[j] = sc.nextLine();
            }
            word = sc.nextLine();
            word = word.toUpperCase();
            System.out.println("Data Set "+ (i+1) +":");
            for(int j = 0; j < N; j++){
                //스펠링 확인
                int wordIndex = 0;
                for(int k = 0; k < arr[j].length(); k++){
                    if(arr[j].toUpperCase().charAt(k)== word.charAt(wordIndex)){
                        wordIndex++;
                        if(wordIndex == word.length()){
                            System.out.println(arr[j]);
                            break;
                        }
                    }
                }
            }
        }
    }
}
