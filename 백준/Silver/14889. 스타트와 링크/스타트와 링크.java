import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static ArrayList<Integer> teamA = new ArrayList<Integer>();
    static ArrayList<Integer> teamB = new ArrayList<Integer>();
    static boolean[] division = new boolean[21];
    static int min = 1987654321;
    static int[][] map = new int[21][21];


    public static void main(String[] ars) throws IOException {
        N= sc.nextInt();

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                map[i][j] = sc.nextInt();

        division(1,N/2);

        System.out.println(min);

    }

    static void division(int index, int count){
        if(count == 0) {
            for(int i = 1; i <= N; i++) {
                if (division[i] == true)
                    teamA.add(i);
                else
                    teamB.add(i);
            }
            min = Math.min(min, calc());
            teamA.clear();
            teamB.clear();
            return;

        }

        for(int i = index; i <= N; i++){
            division[i] = true;
            division(i+1, count-1);
            division[i] = false;
        }
    }

    static int calc(){
        int start = 0;
        int link = 0;
        for(int i = 0; i < N/2-1; i++){
            for(int j = i+1; j < N/2; j++){
                    link += map[teamA.get(i)][teamA.get(j)] + map[teamA.get(j)][teamA.get(i)];
                    start += map[teamB.get(i)][teamB.get(j)] + map[teamB.get(j)][teamB.get(i)];
            }
        }


        return Math.abs(link-start);
    }


}
