import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int H;
    static int W;
    static int[] blocks;
    static int water = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        blocks = new int[W + 1];
        blocks[0] = 987654321;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= H; i++) {

            int start = 0;
            int end = 0;
            for (int j = 1; j <= W; j++) {

                if (blocks[j] >= i) {
                    if (start == 0) {
                        start = j;
                    }
                    end = j;
                }
            }

            for (int j = start; j <= end; j++) {
                if (blocks[j] < i) {
                    water++;
                }
            }
        }

        System.out.println(water);

    }
}