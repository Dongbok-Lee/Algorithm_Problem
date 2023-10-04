import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] arr = new String[1001];

        arr[1] = "SK";
        arr[2] = "CY";
        arr[3] = "SK";
        arr[4] = "SK";
        arr[5] = "SK";

        for (int i = 6; i <= N; i++) {

            int[] num = {1, 3, 4};
            arr[i] = "CY";

            for (int n : num) {
                if (arr[i - n].equals("CY")) {
                    arr[i] = "SK";
                }
            }
        }

        System.out.println(arr[N]);
    }
}

