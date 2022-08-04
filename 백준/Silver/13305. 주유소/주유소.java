import java.io.*;
import java.util.*;
import java.math.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static BigInteger[] stationArr = new BigInteger[100000];
    static BigInteger[] lengthArr = new BigInteger[100000];
    static BigInteger result = BigInteger.valueOf(0);
    static BigInteger minPrice;
    static int curLoc = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        for(int i = 0; i < N-1; i++){
            lengthArr[i] = new BigInteger(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine(), " ");

        for(int i = 0; i < N; i++){
            stationArr[i] = new BigInteger(st.nextToken());
        }

        minPrice = stationArr[0];
        for(int i = 0; i < N-1; i++){
            result = result.add(lengthArr[i].multiply(minPrice));
            if(minPrice.compareTo(stationArr[i+1]) > 0)
                minPrice = stationArr[i+1];
        }

        System.out.println(result);
    }
}

