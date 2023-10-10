import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    static int T;
    static int N;
    static int result;

    static int[][] dp = new int[10][1001];

    static ArrayList<ArrayList<Integer>> nearNumber = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        for(int i = 0; i < 10; i ++){
            nearNumber.add(new ArrayList<>());
        }

        nearNumber.get(0).addAll(List.of(7));
        nearNumber.get(1).addAll(List.of(2, 4));
        nearNumber.get(2).addAll(List.of(1, 5, 3));
        nearNumber.get(3).addAll(List.of(2, 6));
        nearNumber.get(4).addAll(List.of(1, 5, 7));
        nearNumber.get(5).addAll(List.of(2, 4 ,6 ,8));
        nearNumber.get(6).addAll(List.of(3, 5, 9));
        nearNumber.get(7).addAll(List.of(0, 4 ,8));
        nearNumber.get(8).addAll(List.of(5, 7, 9));
        nearNumber.get(9).addAll(List.of(6, 8));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < 10; i++) {
            dp[i][1] = 1;
            dp[i][2] = nearNumber.get(i).size();
        }
        for(int j = 3; j < 1001; j++) {
            for (int i = 0; i < 10; i++) {

                for(Integer num : nearNumber.get(i)){
                    dp[i][j] += dp[num][j - 1];
                }
                dp[i][j] %= 1234567;
            }
        }


        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            for(int j = 0; j < 10; j++) {
                result += dp[j][N];
            }

            System.out.println(result % 1234567);
            result = 0;
        }
    }
}



