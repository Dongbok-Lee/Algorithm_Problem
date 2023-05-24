import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N ,W, L, result = 1, bridgeWeight = 0;
    static Queue<TruckInfo> bridge = new LinkedList<>();
    static Queue<Integer> truckList = new LinkedList<>();
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            truckList.offer(Integer.parseInt(st.nextToken()));

        bridge.offer(new TruckInfo(truckList.poll(), 1));
        bridgeWeight += bridge.peek().weight;

        while(!bridge.isEmpty()){
            result++;

            TruckInfo curT = bridge.peek();

            if(result - curT.time >= W){
                bridge.poll();
                bridgeWeight -= curT.weight;
            }

            if(!truckList.isEmpty() && truckList.peek() + bridgeWeight <= L){
                int curTruck = truckList.peek();
                bridge.offer(new TruckInfo(truckList.poll(), result));
                bridgeWeight += curTruck;
            }
        }
        System.out.println(result);
    }

    static class TruckInfo{
        int weight, time;

        public TruckInfo(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}