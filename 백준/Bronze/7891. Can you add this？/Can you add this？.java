import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    public static void main(String[] args) throws Exception {
        N = sc.nextInt();

        for(int i = 0; i < N; i++){
            System.out.println(sc.nextInt() + sc.nextInt());
        }
    }
}


