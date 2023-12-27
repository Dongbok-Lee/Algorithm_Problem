import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[1001];

        arr[1] = true;
        arr[2] = false;
        arr[3] = true;

        for(int i = 4; i < 1001; i++) {
            arr[i] = !arr[i - 1] || !arr[i - 3];
        }

        if(arr[N]) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }

    }
}