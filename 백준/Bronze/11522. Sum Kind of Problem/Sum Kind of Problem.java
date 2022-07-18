import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int P,K,N;

    public static void main(String[] ars) throws IOException {
        P = Integer.parseInt(reader.readLine());
        for(int i = 1; i <= P; i++) {
            String input = reader.readLine();
            String[] tmp = input.split(" ");
            K = Integer.parseInt(tmp[0]);
            N = Integer.parseInt(tmp[1]);

            writer.write(K + " " + N*(N+1)/2 + " " + (int)Math.pow(N,2) + " " + (int)(Math.pow(N,2)+N)+"\n");

        }
        writer.flush();
        writer.close();
    }
}
