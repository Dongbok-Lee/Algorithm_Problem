import java.util.*;

class Solution {
    
    static HashMap<Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        
        map.put('R', 0); map.put('C', 0); map.put('J', 0); map.put('A', 0);
        map.put('T', 0); map.put('F', 0); map.put('M', 0); map.put('N', 0);
        
        
        for(int i = 0; i < survey.length; i++){
            
            char chr1 = survey[i].charAt(0);
            char chr2 = survey[i].charAt(1);
            
            if(choices[i] < 4){
                map.replace(chr1, map.get(chr1) + 4 - choices[i]);
            }else{
                map.replace(chr2, map.get(chr2) + choices[i] - 4);
            }
        }
        
        String answer = "";
        
        answer += getType('R', 'T');
        answer += getType('C', 'F');
        answer += getType('J', 'M');
        answer += getType('A', 'N');
        
        return answer;
    }
    
    static char getType(char type1, char type2){
        return map.get(type1) >= map.get(type2) ? type1 : type2;
    } 
}