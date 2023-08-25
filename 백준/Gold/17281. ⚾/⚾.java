import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static boolean[] visited;
    static int[][] inning;
    static int[] order = new int[9];
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        inning = new int[N][9];
        visited = new boolean[9];
        order[3] = 0;
        visited[0] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);

    }

    public static void dfs(int index) {

        if (index == 3) {
            dfs(index + 1);
            return;
        }

        if (index == 9) {
            result = Math.max(result, calculateResult());
            return;
        }

        for (int i = 1; i < 9; i++) {

            if (!visited[i]) {
                visited[i] = true;
                order[index] = i;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }

    public static int calculateResult() {
        int result = 0;
        int curOrder = -1;
        for (int i = 0; i < N; i++) {

            boolean[] base = new boolean[4];
            int out = 0;

            while (out != 3) {
                curOrder ++;
                curOrder %= 9;
                base[0] = true;

                if (inning[i][order[curOrder]] == 0) {
                    out++;
                }

                if (inning[i][order[curOrder]] > 0) {
                    for (int j = 3; j >= 0; j--) {
                        if (j + inning[i][order[curOrder]] > 3) {
                            if (base[j]) {
                                base[j] = false;
                                result++;
                            }
                        } else {
                            if (base[j]) {
                                base[j] = false;
                                base[j + inning[i][order[curOrder]]] = true;
                            }
                        }
                    }
                }

            }
        }
        return result;
    }
}