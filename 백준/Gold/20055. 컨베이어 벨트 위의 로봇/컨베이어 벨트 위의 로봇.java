import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int K;
    static int turn;
    static Part[] parts;
    static ArrayList<Integer> robots;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parts = new Part[2 * N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N * 2; i++) {
            parts[i] = new Part(Integer.parseInt(st.nextToken()), false);
        }


        int totalDurability = 0;

        while (totalDurability < K) {
            totalDurability = 0;
            turn++;
            Part nextPart = parts[1];
            for (int i = 1; i < 2 * N + 1; i++) {

                Part curPart = nextPart;

                if (i != 2 * N) {
                    nextPart = parts[i + 1];
                    parts[i + 1] = curPart;
                } else {
                    parts[1] = nextPart;
                }

                if (parts[N].robot) {
                    parts[N].robot = false;
                }
            }

            for (int i = N - 1; i >= 1; i--) {
                if(parts[i].robot) {
                    if(!parts[i + 1].robot && parts[i + 1].durability >= 1) {
                        parts[i].robot = false;
                        parts[i + 1].robot = true;
                        parts[i + 1].durability--;
                    }
                }
            }

            if (parts[N].robot) {
                parts[N].robot = false;
            }

            if (parts[1].durability > 0) {
                parts[1].durability --;
                parts[1].robot = true;
            }

            for (int i = 1; i < 2 * N + 1; i++) {
                if (parts[i].durability == 0) {
                    totalDurability++;
                }
            }

        }


        System.out.println(turn);
    }

}

class Part {
    int durability;
    boolean robot;

    public Part(int durability, boolean robot) {
        this.durability = durability;
        this.robot = robot;
    }
}

