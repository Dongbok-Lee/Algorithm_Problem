import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] buildingNumber;
    static int[] closeBuilding;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        buildingNumber = new int[N];
        closeBuilding = new int[N];

        Arrays.fill(closeBuilding, 987654321);

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Building> s = new Stack<>();

        for(int i = 0; i < N; i++) {

            while(!s.empty() && s.peek().height <= arr[i]) {
                s.pop();
            }

            buildingNumber[i] += s.size();

            if(!s.empty()){
                closeBuilding[i] = s.peek().index;
            }

            s.push(new Building(arr[i], i));
        }

        s = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {

            while(!s.empty() && s.peek().height <= arr[i]) {
                s.pop();
            }

            buildingNumber[i] += s.size();

            if(!s.empty() && (Math.abs(closeBuilding[i] - i) > Math.abs(s.peek().index - i))) {
                    closeBuilding[i] = s.peek().index;
            }

            s.push(new Building(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (buildingNumber[i] == 0) {
                sb.append("0\n");
            } else {
                sb.append(buildingNumber[i] + " " + (closeBuilding[i] + 1) + "\n");
            }
        }

        System.out.println(sb);
    }
}

class Building {
    int height, index;

    public Building(int height, int index) {
        this.height = height;
        this.index = index;
    }
}