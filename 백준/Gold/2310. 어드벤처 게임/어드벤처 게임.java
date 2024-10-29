import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static class VisitInfo {
        int room;
        int money;

        public VisitInfo(int room, int money) {
            this.room = room;
            this.money = money;
        }
    }
    static class Room {
        char type;
        int money;
        List<Integer> connectedRooms;

        public Room() {
        }

        public Room(char type, int money, List<Integer> connectedRooms) {
            this.type = type;
            this.money = money;
            this.connectedRooms = connectedRooms;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int room;
    static List<Room> rooms;
    static int[] visited;
    static boolean result;

    public static void main(String[] args) throws IOException {
        room = Integer.parseInt(br.readLine());

        while (room != 0) {

            result = false;

            rooms = new ArrayList<>();
            rooms.add(new Room());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < room; i++) {
                Room r = new Room(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()), new ArrayList<>());
                int roomNum = Integer.parseInt(st.nextToken());
                while (roomNum != 0) {
                    r.connectedRooms.add(roomNum);
                    roomNum = Integer.parseInt(st.nextToken());
                }
                rooms.add(r);

                st = new StringTokenizer(br.readLine());
            }

            visited = new int[room + 1];
            Arrays.fill(visited, -1);

            dfs(1, 0);

            room = Integer.parseInt(st.nextToken());
            System.out.println(result ? "Yes" : "No");
        }
    }

    static void dfs(int room, int money) {
        Room currentRoom = rooms.get(room);

        if (currentRoom.type == 'L') {
            if(money < currentRoom.money) {
                money = currentRoom.money;
            }
        }

        if (currentRoom.type == 'T') {
            if (money < currentRoom.money) {
                return;
            }

            money -= currentRoom.money;
        }

        if(room == rooms.size() - 1) {
            result = true;
            return;
        }

        for (int connectedRoom : currentRoom.connectedRooms) {
            if (visited[connectedRoom] < money) {
                int tmp = money;
                visited[connectedRoom] = money;
                dfs(connectedRoom, money);
                visited[connectedRoom] = tmp;
            }
        }
    }
}