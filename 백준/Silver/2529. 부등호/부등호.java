import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int k;
    static String max = "9876543210";
    static String min = "0123456789";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        max = max.substring(0, k + 1);
        min = min.substring(0, k + 1);
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {

            if (st.nextToken().equals("<")) {
               right++;

               if (left != 0) {
                   min = reverse(min, i - left, i);
                    left = 0;
               }

            } else {
                left++;

                if (right != 0) {
                    max = reverse(max, i - right, i);
                    right = 0;
                }
            }

            if (i == k - 1) {
                if (right != 0) {
                    max = reverse(max, i + 1 - right, i + 1);
                }else {
                    min = reverse(min, i + 1 - left, i + 1);
                }
            }
        }



        System.out.println(max);
        System.out.println(min);
    }

    static String reverse(String str, int start, int end) {
        char[] array = str.toCharArray();

        while(start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(array);
    }
}