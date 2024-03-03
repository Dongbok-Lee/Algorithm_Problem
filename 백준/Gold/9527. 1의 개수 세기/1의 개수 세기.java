import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long A, B;
    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new long[55];
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        setDp();

        long resultA = getNumberOfOne(A - 1L);
        long resultB = getNumberOfOne(B);
        System.out.println(resultB - resultA);
    }

    static void setDp() {
        dp[1] = 1;

        for(int i = 2; i < 55; i++) {
            dp[i] = dp[i - 1] * 2 + (long)Math.pow(2, i - 1);
        }
    }

    static long getNumberOfOne(long num) {
        int length = (int) (Math.log(num) / Math.log(2)); // log 2 N
        long result = 0;

        for(int i = length; i >= 0; i--) {
            if((1L & (num >> i)) == 1L) {
                result += dp[i] + num - (1L << i) + 1L;
                num -= 1L << i;
            }
        }

        return result;
    }
}

