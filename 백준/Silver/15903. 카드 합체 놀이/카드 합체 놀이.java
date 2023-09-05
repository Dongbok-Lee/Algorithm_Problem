import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    static int N;
    static int M;
    static List<Long> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numList.add((long)Integer.parseInt(st.nextToken()));
            numList.sort(Comparator.comparingLong(a -> a));
        }

        for (int i = 0; i < M; i++) {
            long addNum = numList.get(0) + numList.get(1);
            numList.set(0, addNum);
            numList.set(1, addNum);
            numList.sort(Comparator.comparingLong(a -> a));
        }

        long result = 0;

        for (int i = 0; i < numList.size(); i++) {
            result += numList.get(i);
        }

        System.out.println(result);
    }
}