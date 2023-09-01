import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int T;
    static int N;
    static int M;
    static long dp[];
    static ArrayList<Integer> coinList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- != 0) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            coinList = new ArrayList<>();

            while (N-- != 0) {
                coinList.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());

            dp = new long[M + 1];
            dp[0] = 1;

            for (int coin : coinList) {
                for (int i = 1; i <= M; i++) {
                    if (coin <= i) {
                        dp[i] += dp[i - coin];
                    }
                }
            }

            System.out.println(dp[M]);
        }
    }
}
