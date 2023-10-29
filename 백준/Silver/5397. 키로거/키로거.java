import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            LinkedList<Character> string = new LinkedList<>();
            int cursor = 0;

            String str = br.readLine();

            char[] chars = str.toCharArray();

            for (char c : chars) {
                if(c == '<') {
                    if(cursor > 0) {
                        cursor--;
                    }
                    continue;
                }

                if (c == '>') {
                    if(cursor < string.size()){
                        cursor++;
                    }
                    continue;
                }

                if (c == '-') {
                    if (cursor > 0) {
                        string.remove(cursor - 1);
                        cursor--;
                    }
                    continue;
                }

                string.add(cursor, c);
                cursor++;
            }

            StringBuilder sb = new StringBuilder();
            for(char c : string) {
                sb.append(c);
            }

            System.out.println(sb);
        }


    }
}


