import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int K;
    static int result;
    static int[] arr;
    static int[] number;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = 0;
        number = new int[100001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            number[arr[i]]++;

            if (number[arr[i]] == K + 1 ) {
                result = Math.max(i - start, result);

                while(arr[start] != arr[i]) {
                    number[arr[start]]--;
                    start++;
                }
                number[arr[start]]--;
                start++;
            }

            if (i == N - 1) {
                result = Math.max(i - start + 1, result);
            }
        }

        System.out.println(result);
    }
}

