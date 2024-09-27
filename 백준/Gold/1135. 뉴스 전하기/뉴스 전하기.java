import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] level;
    private static int[] time;
    private static int maxLevel = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        level = new int[N];
        time = new int[N];

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num == -1) {
                continue;
            }

            graph.get(num).add(i);
        }

        dfs(0, 1);

        for(int i = 0; i < N; i++) {
            maxLevel = Math.max(maxLevel, level[i]);
        }

        for(int i = maxLevel; i >= 1; i--) {

            for(int k = 0; k < N; k++) {

                if(level[k] == i) {

                    int node = k;

                    ArrayList<Integer> list = new ArrayList<>();

                    for(int n : graph.get(node)) {
                        list.add(time[n]);
                    }

                    list.sort(Comparator.comparingInt(a -> a));

                    int curTime = 0;

                    for(int j = 0; j < list.size(); j++) {
                        if(curTime < list.get(j)) {
                            curTime += list.get(j) - curTime;
                        }
                        curTime++;
                    }

                    time[node] = curTime;
                }
            }

        }

        System.out.println(time[0]);
    }

    private static void dfs(int node, int lev) {

        level[node] = lev;

        for(int i : graph.get(node)) {
            dfs(i, lev + 1);
        }
    }
}