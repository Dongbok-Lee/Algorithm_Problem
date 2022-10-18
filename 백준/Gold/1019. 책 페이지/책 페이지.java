import java.util.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static String N;
    static long[] arr = new long[10];

    public static void main(String[] args) {
        N = sc.next();

        Arrays.fill(arr,0);

        for(int i = 0; i < N.length(); i++){
            long pre = N.substring(0,i).equals("") ? 0 : Integer.parseInt(N.substring(0,i));
            long cur = N.charAt(i) - '0';
            long next = N.substring(i+1,N.length()).equals("") ? 0 : Integer.parseInt(N.substring(i+1,N.length()));

            int curPlace = N.length() - i-1;

            if(i != 0){
                addNumber(0,0,pre * (long)Math.pow(10,curPlace)-(long)Math.pow(10,curPlace));
            }
            //front
            addNumber(1,9, pre * (long)Math.pow(10,curPlace));

            //cur
            if(i == 0)
                addNumber(1,cur-1, (long)Math.pow(10,curPlace));
            else
                addNumber(0,cur-1, (long)Math.pow(10,curPlace));

            //back
            addNumber(cur,cur, next+1);
        }

        for(int i = 0; i < 10; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static void addNumber(long from, long to, long amount){
        for(int i = (int)from; i <= to; i++)
            arr[i]+= amount;
    }
}
