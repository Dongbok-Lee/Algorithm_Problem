import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int T;
    public static void main(String[] ars) {
        char chr;
        T = sc.nextInt();
        String country;
        sc.nextLine();
        for(int i = 0; i < T; i++){
            country = sc.nextLine();
            chr = country.charAt(country.length()-1);
            if(chr == 'i' || chr == 'a' || chr == 'e' || chr == 'o' || chr == 'u' ||chr == 'I' || chr == 'A' || chr == 'E' || chr == 'O' || chr == 'U')
                System.out.println("Case #"+(i+1)+": "+country + " is ruled by a queen.");
            else if(chr == 'y' || chr == 'Y')
                System.out.println("Case #"+(i+1)+": "+country + " is ruled by nobody.");
            else
                System.out.println("Case #"+(i+1)+": "+country + " is ruled by a king.");
        }
    }
}
