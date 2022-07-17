import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int[] dwarf = new int[9];

    public static void main(String[] ars) {
        for(int i = 0; i < 9; i++){
            dwarf[i] = sc.nextInt();
        }

        Arrays.sort(dwarf);

        for(int i = 0; i < 9; i++){
            for(int j = i; j < 9; j++){
                int sum = 0;

                for(int k = 0; k < 9; k++){
                    if(k != i && k != j){
                        sum += dwarf[k];
                    }
                }

                if(sum == 100){
                    for(int k = 0; k < 9; k++){
                        if(k != i && k != j){
                            System.out.println(dwarf[k]);
                        }
                    }
                    return;
                }
            }
        }
    }
}
