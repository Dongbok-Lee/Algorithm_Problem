import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int T;
    static String W;
    static int K;
    static List<List<Integer>> alphaList;
    static int longLength = 0;
    static int shortLength = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            longLength = 0;
            shortLength = 987654321;
            alphaList = new ArrayList<>();

            for (int j = 0; j < 26; j++) {
                alphaList.add(new ArrayList<>());
            }

            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            for (int j = 0; j < W.length(); j++) {

                int index = W.charAt(j) - 'a';

                alphaList.get(index).add(j);
                if (alphaList.get(index).size() >= K) {
                    List<Integer> cur = alphaList.get(index);
                    int alphaLength = cur.size();
                    shortLength = Math.min(shortLength, cur.get(alphaLength - 1) - cur.get(alphaLength - K));
                    longLength = Math.max(longLength, cur.get(alphaLength - 1) - cur.get(alphaLength - K));
                }
            }

            if (longLength == 0) {
                if (K == 1) {
                    System.out.println(1 + " " + 1);
                }else {
                    System.out.println(-1);
                }
            }else {
                System.out.println((shortLength + 1) + " " + (longLength + 1));

            }
        }
    }
}