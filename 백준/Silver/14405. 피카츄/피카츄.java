import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static String arr;
    static int index = 0;

    public static void main(String[] args) throws Exception {
        arr = sc.nextLine();

        while(index < arr.length()){
            if(arr.length() >= index+2 && (arr.substring(index,index+2).equals("pi") || arr.substring(index,index+2).equals("ka")))
                index += 2;
            else if(arr.length() >= index+3 && arr.substring(index, index+3).equals("chu"))
                index += 3;
            else{
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}