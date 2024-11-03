import java.util.*;

class Solution {
    
    static class Info {
        int index;
        int weight;
        
        public Info(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
    
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        PriorityQueue<Info> q = new PriorityQueue<>((a, b) -> b.weight - a.weight);
        
        for(int i = 0; i < k; i++) {
            q.add(new Info(i, stones[i]));
        }
        
       answer = Math.min(answer, q.peek().weight);
        
        for(int i = k; i < stones.length; i++) {
            
            q.add(new Info(i, stones[i]));
            
            while(!q.isEmpty()) {
                Info cur = q.peek();
                
                if(cur.index <= i - k) {
                    q.poll();
                }else {
                    answer = Math.min(answer, q.peek().weight);
                    break;
                }
            }
        } 
        
        return answer;
    }
}