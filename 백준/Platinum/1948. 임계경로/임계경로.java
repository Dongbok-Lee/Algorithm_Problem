import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<RoadInfo>> roadGraph;
    static ArrayList<ArrayList<RoadInfo>> reverseRoadGraph;
    static int N, M;
    static int cnt, start, end;
    static int inDegree[];
    static int dist[];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        inDegree = new int[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        roadGraph = new ArrayList<ArrayList<RoadInfo>>();
        reverseRoadGraph = new ArrayList<ArrayList<RoadInfo>>();

        for (int i = 0; i <= N; i++){
            roadGraph.add(new ArrayList<RoadInfo>());
            reverseRoadGraph.add(new ArrayList<RoadInfo>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            roadGraph.get(from).add(new RoadInfo(to, cost));
            reverseRoadGraph.get(to).add(new RoadInfo(from, cost));
            inDegree[to]++;
        }
        st = new StringTokenizer(reader.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        saveLongDistance(start);
        findLongestRoad(end);

        System.out.println(dist[end]);
        System.out.println(cnt);
    }

    static void saveLongDistance(int start){

        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(RoadInfo r : roadGraph.get(cur)){

                dist[r.next] = Math.max(dist[cur] + r.cost, dist[r.next]);

                if( --inDegree[r.next] == 0)
                    q.add(r.next);
            }
        }

    }

    static void findLongestRoad(int end){

        Queue<Integer> q = new LinkedList<>();

        q.add(end);
        visited[end] = true;

        while(!q.isEmpty()){

            int cur = q.poll();

            for(RoadInfo r : reverseRoadGraph.get(cur)){
                if(dist[cur] == dist[r.next] + r.cost){
                    cnt++;
                    if(!visited[r.next]){
                        visited[r.next] = true;
                        q.add(r.next);
                    }
                }
            }
        }
    }

}
class RoadInfo{
    int next;
    int cost;

    public RoadInfo(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}