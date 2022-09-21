import java.io.*;
import java.util.*;

class Main {

    static Scanner sc = new Scanner(System.in);
    static int T;

    public static void main(String[] args) throws Exception {
        T = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < T; i++){
            String str = sc.nextLine();

            int first = 0;
            int last = str.length()-1;
            while(true){
                if(str.charAt(first) == str.charAt(last)){
                    first++;
                    last--;
                }
                else{
                    if(isPalindrome(str, first+1,last) || isPalindrome(str, first,last-1)){
                        System.out.println(1);
                        break;
                    }
                    else{
                        System.out.println(2);
                        break;
                    }
                }

                if(first > last){
                    System.out.println(0);
                    break;
                }
            }

        }
    }

    static boolean isPalindrome(String str, int first, int last){
        while(true){
            if(str.charAt(first) == str.charAt(last)){
                first++;
                last--;
            }
            else
                return false;

            if(first > last)
                return true;

        }
    }

}