import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] gearDirectionArr;
    static ArrayList<ArrayList<Integer>> gearArr;

    static int K, result;

    public static void main(String[] args) throws Exception {

        gearDirectionArr = new int[4];
        gearArr = new ArrayList<>();
        
        for(int i = 0; i < 4; i++)
            gearArr.add(new ArrayList<>());


        for(int i = 0; i < 4; i++){
            String str = br.readLine();

            for(int j = 0; j < 8; j++){
                gearArr.get(i).add(str.charAt(j) - '0');
            }
        }


        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(st.nextToken())-1;
            int gearDirection = Integer.parseInt(st.nextToken());

            if(gearDirection == -1)
                gearDirection = 0;

            Arrays.fill(gearDirectionArr, -1);
            rightRotation(gearNum, gearDirection);
            leftRotation(gearNum, gearDirection);
            doRotation();
        }
        int score = 1;
        for(int i = 0; i < 4; i++){
            if(gearArr.get(i).get(0) == 1)
                result += score;
            score *= 2;
        }

        System.out.println(result);
    }

    static void rightRotation(int gear, int direction){

        gearDirectionArr[gear] = direction;

        if(gear == 3)
            return;

        if(direction == 1){
            if(gearArr.get(gear).get(2) != gearArr.get(gear + 1).get(6)){
                rightRotation(gear+1, 0);
            }
        }
        else{
            if(gearArr.get(gear).get(2) != gearArr.get(gear + 1).get(6)){
                rightRotation(gear+1, 1);
            }
        }
    }


    static void leftRotation(int gear, int direction){

        gearDirectionArr[gear] = direction;

        if(gear == 0)
            return;

        if(direction == 1){
            if(gearArr.get(gear).get(6) != gearArr.get(gear - 1).get(2)){
                leftRotation(gear-1, 0);
            }
        }
        else{
            if(gearArr.get(gear).get(6) != gearArr.get(gear - 1).get(2)){
                leftRotation(gear - 1, 1);
            }
        }
    }

    static void clockRotation(int gearNum){
        int num = gearArr.get(gearNum).remove(7);
        gearArr.get(gearNum).add(0, num);
    }

    static void counterClockRotation(int gearNum){
        int num = gearArr.get(gearNum).remove(0);
        gearArr.get(gearNum).add(num);
    }

    static void doRotation(){
        for(int i = 0; i < 4; i++){
            if (gearDirectionArr[i] == 1)
                clockRotation(i);
            else if(gearDirectionArr[i] == 0)
                counterClockRotation(i);

        }
    }
}