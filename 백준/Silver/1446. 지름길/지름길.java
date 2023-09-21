import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int D;
    static int result = 987654321;

    static FastRoad[] roads;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        roads = new FastRoad[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i] = new FastRoad(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(roads, (a, b) -> a.start - b.start);
        dfs(0, 0, -1);

        System.out.println(result);
    }

    public static void dfs(int start, int total, int index) {

        for(int i = index  + 1; i < N; i++) {
            if(roads[i].start >= start) {
                dfs(roads[i].end, total + roads[i].start - start + roads[i].length, i);
            }
        }

        if (start <= D) {
            result = Math.min(result, total + D - start);
        }
    }

}

class FastRoad {
    int start;
    int end;
    int length;

    public FastRoad(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}
