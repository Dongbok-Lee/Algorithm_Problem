import java.util.*;
import java.io.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] curStatus = new int[100001];
    static int[] goal = new int[100001];
    static int[] arr1 = new int[100001];
    static int[] arr2 = new int[100001];
    static int count1 = 0, count2 = 1;


    public static void main(String[] args) {
        N = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String str2 = sc.nextLine();

        for(int i = 0; i < N; i++){
            curStatus[i] = Character.getNumericValue(str.charAt(i));
            arr1[i] = Character.getNumericValue(str.charAt(i));
            arr2[i] = Character.getNumericValue(str.charAt(i));
            goal[i] = Character.getNumericValue(str2.charAt(i));
        }

        arr2[0] = Math.abs(arr2[0]-1);
        arr2[1] = Math.abs(arr2[1]-1);

        for(int i = 1; i < N; i++){
            if(arr1[i-1] != goal[i-1]){
                arr1[i-1] = Math.abs(arr1[i-1]-1);
                arr1[i] = Math.abs(arr1[i]-1);
                arr1[i+1] = Math.abs(arr1[i+1]-1);
                count1++;
            }
            if(arr2[i-1] != goal[i-1]){
                arr2[i-1] = Math.abs(arr2[i-1]-1);
                arr2[i] = Math.abs(arr2[i]-1);
                arr2[i+1] = Math.abs(arr2[i+1]-1);
                count2++;
            }
        }


        if(goal[N-1] == arr1[N-1] && goal[N-1] == arr2[N-1])
            System.out.println(Math.min(count1,count2));
        else if(goal[N-1] == arr1[N-1])
            System.out.println(count1);
        else if(goal[N-1] == arr2[N-1])
            System.out.println(count2);
        else
            System.out.println(-1);

    }
}