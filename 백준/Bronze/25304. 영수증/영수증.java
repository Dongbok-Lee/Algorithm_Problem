import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int X;
    static int N;
    static int price;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        X = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            price += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        if(price == X) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}