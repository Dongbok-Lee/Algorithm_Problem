import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int result = 0;

    public static void main(String[] ars) {
        int CA = sc.nextInt();
        int BA = sc.nextInt();
        int PA = sc.nextInt();

        int CR = sc.nextInt();
        int BR = sc.nextInt();
        int PR = sc.nextInt();

        if(CA < CR)
            result += CR-CA;
        if(BA < BR)
            result += BR-BA;
        if(PA < PR)
            result += PR-PA;

        System.out.println(result);
    }
}

