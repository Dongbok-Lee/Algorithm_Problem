import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sbS = new StringBuilder().append(S);
        StringBuilder sbT = new StringBuilder().append(T);

        dfs(sbS, sbT);

        System.out.println(result);

    }

    public static void dfs(StringBuilder s, StringBuilder t){

        if(s.length() == t.length()) {
            if(s.toString().equals(t.toString())){
                result = 1;
            }
            return;
        }

        StringBuilder s1 = new StringBuilder().append(s);
        StringBuilder s2 = new StringBuilder().append(s);

        s1.append("A");

        StringBuilder tmp = new StringBuilder().append(s1);

        if (t.toString().contains(s1) || t.toString().contains(tmp.reverse())) {
            dfs(s1, t);
        }

        s2.append("B").reverse();

        tmp = new StringBuilder().append(s2);

        if (t.toString().contains(s2) || t.toString().contains(tmp.reverse())) {
            dfs(s2, t);
        }
    }
}

