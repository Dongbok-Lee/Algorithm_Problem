import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] color = new int[16][3];
    public static void main(String[] ars) throws IOException {
        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 3; j++) {
                color[i][j] = sc.nextInt();
            }
        }

        int R, G, B;
       while(sc.hasNext()){
            R = sc.nextInt();
            G = sc.nextInt();
            B = sc.nextInt();
            int index = 0;
            double D = 1987654321;

            for(int i = 0; i < 16; i++){
                double tmp = Math.sqrt(Math.pow(color[i][0] - R,2) + Math.pow(color[i][1] -G,2) + Math.pow(color[i][2] - B,2));

                if(D > tmp){
                    D = tmp;
                    index = i;
                }
            }

            System.out.println(String.format("%3d",R) + " "+ String.format("%3d",G) + " "+ String.format("%3d",B) +" maps to " + String.format("%3d",color[index][0]) + " "+ String.format("%3d",color[index][1]) + " "+ String.format("%3d",color[index][2]));
        }
    }
}
