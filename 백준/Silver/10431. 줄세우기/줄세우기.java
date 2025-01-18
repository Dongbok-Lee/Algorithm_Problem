import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            result = 0;
            LinkedList<Integer> line = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int testNumber = Integer.parseInt(st.nextToken());
            makeLine(line);
            System.out.println(testNumber + " " + result);
        }

    }


    static void makeLine(LinkedList<Integer> line) throws IOException {

        for(int i = 0; i < 20; i++) {
            int height = Integer.parseInt(st.nextToken());

            sortLine(line, height, i);
        }
    }

    static void sortLine(LinkedList<Integer> line, int height, int personNumber) throws IOException {
        for(int i = 0; i < personNumber; i++) {
            if(line.get(i) > height) {
                line.add(i, height);
                result += (personNumber - i);
                return;
            }
        }
        line.add(height);
    }
}