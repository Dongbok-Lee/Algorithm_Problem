import java.io.*;
import java.util.*;

class Main{
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String str = sc.nextLine();
        String str2 = sc.nextLine();

        for(int i = 0; i  <= str.length() - str2.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str.charAt(i+j) == str2.charAt(j)){
                    if(j == str2.length()-1){
                        count++;
                        i+= j;
                    }
                }
                else
                    break;

            }
        }

        System.out.println(count);
    }
}