import java.util.*;

class Main{

    static Scanner sc = new Scanner(System.in);
    static int T;
    static String str;

    public static void main(String[] args) {

        T = sc.nextInt();

        while(T-- > 0){
            str = sc.next();
            String result = "YES";

            for (int i = 0; i < str.length() && result == "YES"; i++){
                if(i + 2 <= str.length() && str.substring(i, i+2).equals("01"))
                    i ++;

                else if(i + 3 < str.length() && str.substring(i, i+3).equals("100")){
                    for(int j = i + 3; j < str.length(); j++){
                        if(str.charAt(j) == '1'){
                            for(int k = j; k < str.length(); k++){
                                if(str.charAt(k) == '1'){
                                    i = k;
                                    if((k+3 <= str.length() && str.substring(k+1,k+3).equals("01")) || (k+4 <= str.length() && str.substring(k+1,k+4).equals("100"))){
                                        break;
                                    }
                                }
                                else{
                                    result = "NO";
                                    break;
                                }

                            }
                            break;
                        }

                        if(j == str.length()-1)
                            result = "NO";


                    }
                }

                else
                    result = "NO";
            }
            System.out.println(result);
        }
    }
}