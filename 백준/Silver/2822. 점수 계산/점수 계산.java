import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] score = new int[8];
    static int[] sorted = new int[8];
    static int sum = 0;

    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 8; i++){
            score[i] = sc.nextInt();
            sorted[i] = score[i];
        }

        Arrays.sort(sorted);

        for(int i = 3; i < 8; i++){
            sum += sorted[i];
        }

        System.out.println(sum);

        for(int i = 0; i < 8; i++){
            for(int j = 3; j < 8; j++){
                if(score[i] == sorted[j]){
                    System.out.print(i+1 + " ");
                }
            }
        }

    }
}
