import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int maxHeight = 0;
    static int result = 0;
    static int[] buildings;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!s.empty()) {

                if(s.peek() > y) {
                    s.pop();
                    result++;
                }else if(s.peek() == y) {
                    s.pop();
                }else {
                    break;
                }
            }

            s.push(y);
        }

        while ( !s.empty() && s.peek() != 0) {
            s.pop();
            result++;
        }

        System.out.println(result);
    }
}