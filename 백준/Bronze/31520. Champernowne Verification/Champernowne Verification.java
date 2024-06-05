import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String temp = "";
        for(int i = 1; i <= 10; i++) {
            temp += i;

            if(str.equals(temp)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}