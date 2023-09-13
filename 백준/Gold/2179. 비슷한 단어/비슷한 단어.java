import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static TreeMap<String, Integer> map;
    static int maxPrefix = 0;
    static int maxPrefixIndex = 999999;
    static String prefix = "";
    static String S;
    static String C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if(!map.containsKey(key)){
                map.put(key, i);
            }
        }
        Set<String> keySet = map.keySet();

        Iterator<String> it = keySet.iterator();

        String aa = "";
        String bb;

        if (it.hasNext()){
            aa = it.next();
        }

        while(it.hasNext()){

            bb = aa;
            aa = it.next();

            String a;
            String b;

            if(map.get(aa) > map.get(bb)) {
                a = bb;
                b = aa;
            } else {
                a = aa;
                b = bb;
            }

            getMaxPrefix(a, b);
        }

        Iterator<String> itra = map.keySet().iterator();
        int minIndex = 99999999;
        while (itra.hasNext()) {
            String s = itra.next();
            if(s.length() >= prefix.length()){
                if (!s.equals(S) && prefix.equals(s.substring(0, prefix.length())) && map.get(s) < minIndex) {
                    minIndex = map.get(s);
                    C = s;
                }
            }
        }

        if (prefix.isEmpty()) {
            Iterator<String> itr = map.keySet().iterator();
            while (itr.hasNext()) {
                String str = itr.next();
                if (map.get(str) == 0) {
                    S = str;
                }

                if (map.get(str) == 1) {
                    C = str;
                }
            }
        }

        System.out.println(S);
        System.out.println(C);
    }

    public static void getMaxPrefix(String a, String b) {
        int minLength = Math.min(a.length(), b.length()) - 1;

        for (int i = 0; i <= minLength; i++) {
            if (a.charAt(i) != b.charAt(i) || i == minLength) {

                if (i == minLength && a.charAt(i) == b.charAt(i)) {
                   i++;
                }

                if (i == maxPrefix) {
                    if (maxPrefixIndex > map.get(a)) {

                        prefix = a.substring(0, i);
                        maxPrefixIndex = map.get(a);
                        S = a;
                        C = b;
                    }
                } else if (i > maxPrefix) {

                    maxPrefix = i;
                    prefix = a.substring(0, i);
                    maxPrefixIndex = map.get(a);
                    S = a;
                    C = b;
                }
                break;
            }
        }
    }
}