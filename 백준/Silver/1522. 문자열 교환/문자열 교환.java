import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static String str;
    static int result = 987654321;
    static int b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'b') {
                b++;
            }
        }

        for (int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == 'b') {
                getResult(i ,str);
            }
        }

        if(result == 987654321){
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

    public static void getResult(int index, String str){

        int aNum = 0;
        int bNum = b;

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt((index + i) % str.length())  == 'a') {
                aNum++;
            }else {
                bNum--;
            }

            if(bNum - 1 == aNum) {
                result = Math.min(aNum, result);
            }
        }

    }
}