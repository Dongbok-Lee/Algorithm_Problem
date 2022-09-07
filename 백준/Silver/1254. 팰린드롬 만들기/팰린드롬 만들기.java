import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static String arr;
    static String arr2 = "";
    static int arrLength;
    static int result = 987879;

    public static void main(String[] args) throws Exception {

        arr = sc.nextLine();
        arrLength = arr.length();

        for(int i = arr.length()-1; i >= 0; i--){
            for(int j = i; j < arr.length(); j++)
                arr2 += arr.charAt(j);

            if(checkPalindrome(arr2) == true)
                result = Math.min(result, arr.length() * 2 - arr2.length());

            arr2 = "";
        }

        System.out.println(result);
    }

    static boolean checkPalindrome(String arr){
        for(int i = 0; i <= arr.length()/2; i++)
            if(arr.charAt(i) != arr.charAt(arr.length()-i-1))
                return false;

        return true;
    }

}