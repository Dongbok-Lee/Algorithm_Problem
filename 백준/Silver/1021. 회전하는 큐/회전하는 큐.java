import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, result = 0;
    static Deque dq = new ArrayDeque<Integer>();

    public static void main(String[] ars) throws IOException {
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++)
            dq.offerLast(i);

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            int count = 0;
            while (true) {
                if ((int)dq.getFirst() == num){
                    dq.pollFirst();
                    break;
                }

                dq.offerLast(dq.getFirst());
                dq.pollFirst();
                count++;
            }
            result += Math.min(count, dq.size()-count+1);
        }

        System.out.println(result);
    }
}
