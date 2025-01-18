import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        long result = 0;
        int[] arr = new int[n + 1];

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i <= n; i++) {
            int curHeight = arr[i];
            long width = 0;
            long height = 0;
            while(!s.isEmpty() && arr[s.peek()] >= curHeight) {

                height = arr[s.pop()];

                width = i;

                if(!s.isEmpty()) {
                    width -= s.peek() + 1;
                }

                result = Math.max(result, width * height);
            }

            s.add(i);
        }

        System.out.println(result);

    }

}

