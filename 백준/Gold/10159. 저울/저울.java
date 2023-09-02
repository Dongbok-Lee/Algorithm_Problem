import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int M;
    static List<Set<Integer>> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            list.get(small).add(big);
        }

        for (int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (list.get(j).contains(i)) {
                    for (int num2 : list.get(i)) {
                        list.get(j).add(num2);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int result = N - 1;

            result -= list.get(i).size();

            for (int j = 1; j <= N; j++) {
                if (list.get(j).contains(i)) {
                    result--;
                }
            }

            System.out.println(result);
        }
    }
}
