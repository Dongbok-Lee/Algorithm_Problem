import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String word;
    static String minWord = "";
    public static void main(String[] ars) {
        word = sc.nextLine();
        char[] charArr = word.toCharArray();

        //자를 부분 i = 첫번째 j는 두번째
        for(int i = 1; i < word.length()-1; i++){
            for(int j = i+1; j < word.length(); j++){
                // 단어 뒤집기
                for(int k = i-1; k >= 0; k--)
                    charArr[i-k-1] = word.charAt(k);

                for(int k = j-1; k > i-1; k--)
                    charArr[i+j-k-1] = word.charAt(k);

                for(int k = word.length()-1; k > j-1; k--)
                    charArr[word.length()-k+j-1] = word.charAt(k);

                if(minWord.equals("") || minWord.compareTo(String.valueOf(charArr))>=0)
                    minWord = String.valueOf(charArr);

            }
        }
        System.out.println(minWord);
    }
}
