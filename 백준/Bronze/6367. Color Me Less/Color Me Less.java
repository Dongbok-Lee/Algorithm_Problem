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
        while(true){
            R = sc.nextInt();
            G = sc.nextInt();
            B = sc.nextInt();
            int index = 0;
            double D = 1987654321;

            if(R == -1 && G == -1 && B == -1)
                return;

            for(int i = 0; i < 16; i++){
                double tmp = Math.sqrt(Math.pow(color[i][0] - R,2) + Math.pow(color[i][1] -G,2) + Math.pow(color[i][2] - B,2));

                if(D > tmp){
                    D = tmp;
                    index = i;
                }
            }

            System.out.println("("+ R + ","+ G + ","+ B +") maps to (" + color[index][0] + ","+ color[index][1] + ","+ color[index][2]+ ")");
        }
    }
}
