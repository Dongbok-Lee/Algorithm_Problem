import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int a = 0;
        int b = 0;

        for(char c : str.toCharArray()){
            if(c == 'A') a++;
            else b++;
        }

        if(a > b) System.out.println("A");
        else if(a < b) System.out.println("B");
        else System.out.println("Tie");
    }
}