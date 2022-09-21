import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int T;
    public static void main(String[] ars) {
        T = sc.nextInt();

        int stage;
        double weight;

        for(int i = 0; i < T; i++){
          stage = sc.nextInt();
          weight = sc.nextDouble();
          double result = 0;
          double V = 0;
          double[] M = new double[31];
          double[] T = new double[31];
          double[] F = new double[31];

          for(int j = 0; j < stage; j++){
              M[j] = sc.nextDouble();
              T[j] = sc.nextDouble();
              F[j] = sc.nextDouble();
          }

          M[stage-1] += weight;

          for(int j = stage-2; j >= 0; j--)
              M[j] = M[j+1] + M[j];

          for(int j = 0; j < stage; j++){
              double A = F[j] / M[j] - 9.81;
              double D = V*T[j] + 0.5*A*T[j]*T[j];
              V = V + A*T[j];
              result += D;
          }
          System.out.println("Data Set "+ (i+1) +":");
          System.out.println(String.format("%.2f",result));

        }
    }
}
