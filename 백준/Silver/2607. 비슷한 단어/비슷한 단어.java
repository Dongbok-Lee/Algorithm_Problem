import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int N;
    static String initWord;
    static int[] alpha = new int[26];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        initWord = br.readLine();

        checkAlpha(alpha, initWord);

        for (int i = 0; i < N - 1; i++) {
            int[] alphaCheck = new int[26];
            checkAlpha(alphaCheck, br.readLine());
            checkSimilar(alphaCheck);
        }

        System.out.println(result);
    }

    public static void checkAlpha(int[] alpha, String str) {

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A']++;
        }
    }

    public static void checkSimilar(int[] alphaCheck) {
        int addCheckNum = 0;
        int minusCheckNum = 0;
        for (int i = 0; i <= 'Z' - 'A'; i++) {
            if (Math.abs(alphaCheck[i] - alpha[i]) > 1) {
                return;
            }

            if (alpha[i] == alphaCheck[i] + 1) {
                addCheckNum++;
            }

            if (alphaCheck[i] == alpha[i] + 1) {
                minusCheckNum++;
            }
        }

        if (minusCheckNum < 2 && addCheckNum < 2) {
           result++;
        }
    }
}