import java.io.*;
import java.util.*;

class Main{


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, minBlindSpot = 10000000;
    static int[][] map;
    static ArrayList<CameraInfo> cameraList;
    public static void main(String[] args) throws Exception {

        cameraList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] != 0 && map[i][j] != 6){
                    cameraList.add(new CameraInfo(map[i][j], i, j));
                }
            }
        }

        getMinBlindSpotByDFS(0, map);

        System.out.println(minBlindSpot);
    }

    static void getMinBlindSpotByDFS(int index, int[][] map){

        if(cameraList.size() == index){
            minBlindSpot = Math.min(getBlindSpot(map), minBlindSpot);
            return;
        }


        int cameraNum = cameraList.get(index).cameraType;
        int x = cameraList.get(index).x;
        int y = cameraList.get(index).y;


        switch(cameraNum){

            case 1:
                for(int i = 0; i < 4; i++){
                    int[][] newMap = copyMap(map);
                    setCameraRange(newMap, i, x, y);
                    getMinBlindSpotByDFS(index + 1, newMap);
                }
                break;
            case 2:
                for(int i = 0; i < 2; i++){
                    int[][] newMap = copyMap(map);
                    setCameraRange(newMap, i, x, y);
                    setCameraRange(newMap, i + 2, x, y);
                    getMinBlindSpotByDFS(index + 1, newMap);
                }
                break;
            case 3:
                for(int i = 0; i < 4; i++){
                    int[][] newMap = copyMap(map);
                    setCameraRange(newMap, i, x, y);
                    setCameraRange(newMap, (i + 1) %  4, x, y);
                    getMinBlindSpotByDFS(index + 1, newMap);
                }
                break;
            case 4:
                for(int i = 0; i < 4; i++){
                    int[][] newMap = copyMap(map);
                    setCameraRange(newMap, i, x, y);
                    setCameraRange(newMap, (i + 1) %  4, x, y);
                    setCameraRange(newMap, (i + 2) %  4, x, y);
                    getMinBlindSpotByDFS(index + 1, newMap);
                }
                break;
            case 5:
                int[][] newMap = copyMap(map);
                setCameraRange(newMap, 0, x, y);
                setCameraRange(newMap, 1, x, y);
                setCameraRange(newMap, 2, x, y);
                setCameraRange(newMap, 3, x, y);
                getMinBlindSpotByDFS(index + 1, newMap);
                break;
        }
    }

    static void setCameraRange(int[][] map, int direction, int x, int y){

        switch(direction){
            case 0:
                while(x >= 0 && map[x][y] != 6){
                    map[x][y] = 9;
                    x--;
                }
                break;
            case 1:
                while(y < M && map[x][y] != 6){
                    map[x][y] = 9;
                    y++;
                }
                break;
            case 2:
                while(x < N  && map[x][y] != 6){
                    map[x][y] = 9;
                    x++;
                }
                break;
            case 3:
                while(y >= 0 && map[x][y] != 6){
                    map[x][y] = 9;
                    y--;
                }
                break;
        }
    }

    static int[][] copyMap(int[][] map){
        int[][] copyMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }

    static int getBlindSpot(int[][] map){

        int blindSpot = 0;

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    blindSpot++;
                }
            }
        }

        return blindSpot;
    }

    static class CameraInfo{
        int cameraType, x, y;

        public CameraInfo(int cameraType, int x, int y) {
            this.cameraType = cameraType;
            this.x = x;
            this.y = y;
        }
    }
}