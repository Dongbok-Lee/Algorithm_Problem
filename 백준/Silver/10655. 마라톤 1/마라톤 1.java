import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, result = 0;
    static int[] distanceArr;
    static Point[] pointArr;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        distanceArr = new int[N + 1];
        pointArr = new Point[N + 1];

        st = new StringTokenizer(br.readLine());

        pointArr[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i = 2; i <= N ; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointArr[i] = new Point(x, y);
            distanceArr[i] = distanceArr[i-1] + getDistance(pointArr[i - 1].x, pointArr[i - 1].y, pointArr[i].x, pointArr[i].y);
        }

        for(int i = 1; i <= N - 2; i++){
            int distance  = distanceArr[i + 2] - distanceArr[i];
            int shortDistance = getDistance(pointArr[i + 2].x, pointArr[i + 2].y, pointArr[i].x, pointArr[i].y);

            result = Math.max(result, distance - shortDistance);
        }

        System.out.println(distanceArr[N] - result);
    }

    static int getDistance(int x, int y, int x2, int y2){
        return Math.abs(x - x2) + Math.abs(y - y2);
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}