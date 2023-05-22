import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, L, K;
    static ArrayList<Point> starPoint;
    static int safeStar = 0;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        starPoint = new ArrayList<Point>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            starPoint.add(new Point(x, y));
        }

        for(Point p : starPoint){
            for(Point p2 : starPoint){

                if(p2.x <= p.x){
                    int result = 0;
                    int yStart = p.y; int yEnd = p.y + L;
                    int xStart = p2.x; int xEnd = p2.x + L;

                    for(Point p3 : starPoint){
                        if(isInside(p3, xStart, xEnd, yStart, yEnd)){
                            result++;
                        }
                    }

                    safeStar = Math.max(safeStar, result);
                }

            }
        }

        System.out.println(K - safeStar);
    }

    static boolean isInside(Point p, int xStart, int xEnd, int yStart, int yEnd){
        return xStart <= p.x && p.x <= xEnd && yStart <= p.y && p.y <= yEnd;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}