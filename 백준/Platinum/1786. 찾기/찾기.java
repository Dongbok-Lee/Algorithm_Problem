import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static String T, P;
    static int[] pi;
    static ArrayList<Integer> list = new ArrayList<>();
    static int result = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        T = reader.readLine();
        P = reader.readLine();

        pi = new int[P.length()];

        getPi();
        getKMP();

        writer.write(result + "\n");
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

    static void getPi(){

        int j = 0;

        for(int i = 1; i < P.length(); i++){
            while( j > 0 && P.charAt(i) != P.charAt(j))
                j = pi[j - 1];
            if(P.charAt(i) == P.charAt(j))
                pi[i] = ++j;
        }
    }

    static void getKMP(){
        int j = 0;

        for(int i = 0; i < T.length(); i++){

            while( j > 0 && T.charAt(i) != P.charAt(j))
                j = pi[j - 1];

            if(T.charAt(i) == P.charAt(j))
                j++;

            if(j == P.length()){
                sb.append((i - P.length() + 2) + " ");
                result++;
                j = pi[j - 1];
            }
        }
    }
}