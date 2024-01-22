import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] roomsNum;
    static int roomNum = 0;
    static int maxRoom = 0;
    static int plusMaxArea = 0;
    static int[] roomsArea;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        roomsNum = new int[N][M];
        roomsArea = new int[2501];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (!visited[i][j]) {
                    int rooms = 0;
                    visited[i][j] = true;
                    roomsNum[i][j] = ++roomNum;

                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i, j));

                    while (!q.isEmpty()) {
                        rooms++;
                        Node curNode = q.poll();
                        int[] wallInfo = new int[4];

                        int wall = map[curNode.x][curNode.y];
                        wallInfo[0] = wall / 8;
                        wall %= 8;
                        wallInfo[1] = wall / 4;
                        wall %= 4;
                        wallInfo[2] = wall / 2;
                        wall %= 2;
                        wallInfo[3] = wall;

                        for (int k = 0 ; k < 4; k++) {
                            int nextX = curNode.x + dx[k];
                            int nextY = curNode.y + dy[k];
                            if (wallInfo[k] == 0 && isInside(nextX, nextY) && !visited[nextX][nextY]) {
                                    visited[nextX][nextY] = true;
                                    roomsNum[nextX][nextY] = roomNum;
                                    q.offer(new Node(nextX, nextY));
                            }
                        }
                    }
                    roomsArea[roomNum] = rooms;
                    maxRoom = Math.max(rooms, maxRoom);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int room1 = roomsNum[i][j];

                for (int k = 0; k < 4; k++) {
                    if (isInside(i + dx[k], j + dy[k])) {
                        int room2 = roomsNum[i + dx[k]][j + dy[k]];

                        if(room1 != room2) {
                            plusMaxArea = Math.max(plusMaxArea, roomsArea[room1] + roomsArea[room2]);
                        }
                    }
                }
            }
        }

        System.out.println(roomNum);
        System.out.println(maxRoom);
        System.out.println(plusMaxArea);
    }

    static boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}