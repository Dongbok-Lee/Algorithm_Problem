import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    public static void main(String[] args) throws IOException {

        for(int i = 0; i < 4; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();

            for(int j = 0; j < 8; j++){
                if(j % 2 == 0){
                    if(a.charAt(j) == 'F')
                        count++;
                }
                else{
                    if(b.charAt(j) == 'F')
                        count++;
                }
            }
        }

        System.out.println(count);
    }
}


