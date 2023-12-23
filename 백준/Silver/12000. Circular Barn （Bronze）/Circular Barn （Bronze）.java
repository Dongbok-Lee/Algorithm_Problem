import java.io.*;

class Main {
    static int N, distance = 1987654321;
    static int[] barns;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        barns = new int[N];

        for (int i = 0; i < N; i++) {
            barns[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int tmp = 0;

            for (int j = 0; j < N; j++) {
                if (i <= j) {
                    tmp += barns[j] * (j - i);
                } else {
                    tmp += barns[j] * (N - (i - j));
                }
            }

            if(tmp < distance) {
                distance = tmp;
            }
        }

        System.out.println(distance);
    }
}