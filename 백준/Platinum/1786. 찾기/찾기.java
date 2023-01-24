import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static String T, P;
    static int[] pi;
    static ArrayList<Integer> list = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) {
        T = sc.nextLine();
        P = sc.nextLine();

        pi = new int[P.length()];

        getPi();
        getKMP();

        System.out.println(result);
        for(int i : list)
            System.out.print(i + " ");
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
                result++;
                list.add(i - P.length() + 2);
                j = pi[j - 1];
            }
        }
    }
}