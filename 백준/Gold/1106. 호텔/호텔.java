import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static MarketingCost[] city;
    static int result = 987654321;
    static int[] array;
    static int marketingMaxPerson = 0;
    static int N, C;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        city = new MarketingCost[C];
        array = new int[1101];
        Arrays.fill(array, 987654321);
        array[0] = 0;

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            city[i] = new MarketingCost(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (MarketingCost m : city) {
            marketingMaxPerson = Math.max(m.person, marketingMaxPerson);
        }

        for (int i = 1; i <= N + marketingMaxPerson; i++) {
            for (MarketingCost m : city) {
                int index = 0;
                if (i - m.person < 0){
                    index = 0;
                }else{
                    index = i - m.person;
                }

                array[i] = Math.min(array[index] + m.cost, array[i]);
            }
        }

        for (int i = N; i <= N + marketingMaxPerson; i++) {
            result = Math.min(result, array[i]);
        }

        System.out.println(result);
    }

}

class MarketingCost {
    int cost;
    int person;

    public MarketingCost(int cost, int person) {
        this.cost = cost;
        this.person = person;
    }
}