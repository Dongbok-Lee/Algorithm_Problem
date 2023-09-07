import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[] citizen;
    static boolean[] zone;
    static List<List<Integer>> graph = new ArrayList<>();
    static int result = 1987654321;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        citizen = new int[N + 1];
        zone = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            citizen[i] = Integer.parseInt(st.nextToken());
        }

        graph.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            graph.add(new ArrayList<>());

            int nearZone = Integer.parseInt(st.nextToken());

            for (int j = 0; j < nearZone; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1);

        if (result == 1987654321) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    public static void dfs(int num) {
        if (num == N + 1) {
            if(checkAvailable()) {
                calculateResult();
            }
            return;
        }

        zone[num] = true;
        dfs(num + 1);

        zone[num] = false;
        dfs(num + 1);
    }

    public static boolean checkAvailable() {
        List<Integer> aTeam = new ArrayList<>();
        List<Integer> bTeam = new ArrayList<>();
        boolean[] availableNum = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (zone[i]) {
               aTeam.add(i);
            } else {
                bTeam.add(i);
            }
        }

        if(aTeam.isEmpty() || bTeam.isEmpty()){
            return false;
        }
        availableNum[aTeam.get(0)] = true;

        if(aTeam.size() > 1) {
            for (int i = 1; i < aTeam.size(); i++){
                availableNum[aTeam.get(i)] = bfs(aTeam.get(i), aTeam.get(0), bTeam);
            }
        }

        availableNum[bTeam.get(0)] = true;
        if(bTeam.size() > 1) {
            for (int i= 1; i < bTeam.size(); i++) {
                availableNum[bTeam.get(i)] = bfs(bTeam.get(i), bTeam.get(0), aTeam);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!availableNum[i]) {
                return false;
            }
        }

        return true;
    }

    public static void calculateResult() {
        int aTeam = 0;
        int bTeam = 0;

        for (int i = 1; i <= N; i++) {
            if (zone[i]) {
                aTeam += citizen[i];
            }else {
                bTeam += citizen[i];
            }
        }

        result = Math.min(Math.abs(aTeam - bTeam), result);
    }

    public static boolean bfs(int i, int j, List<Integer> list){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[i] = true;
        q.offer(i);

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int n : graph.get(num)) {

                if (n == j) {
                    return true;
                }

                if (!visited[n] && !list.contains(n)) {
                    q.add(n);
                }

                visited[n] = true;
            }
        }

        return false;
    }
}

