import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        
        int answer = 0;
        
        for(int i = 0; i < queue1.length; i++){
            
            q1Sum += queue1[i];
            q2Sum += queue2[i];
            
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        int qSize = q1.size() * 2;
        
        while(q1Sum != q2Sum){
            
            answer++;
            int num = -1;
            
            if(q1Sum > q2Sum){
                num = q1.poll();
                q2.offer(num);
                q1Sum -= num;
                q2Sum += num;
            }else{
                num = q2.poll();
                q1.offer(num);
                q1Sum += num;
                q2Sum -= num;
            }
            
            if(qSize == -10){
                answer = -1;
                break;
            }
            
            qSize--;
            
        }
        
        return answer;
    }
}