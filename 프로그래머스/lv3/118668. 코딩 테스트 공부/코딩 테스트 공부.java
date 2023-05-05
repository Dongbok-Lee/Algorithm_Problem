class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        int[][] dp = new int[501][501];
        int maxAlp = alp;
        int maxCop = cop;
              
        for(int i = alp; i < 501; i++){
           for(int j = cop; j < 501; j++){
                dp[i][j] = i+j-alp-cop;
            }
        }

                

        for(int[] p :problems){
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }
        
        for(int i = alp; i < 451; i++){
            for(int j = cop; j < 451; j++){
                
                for(int[] p : problems){
                    if(i  >= p[0] && j  >= p[1] ){
                        dp[i +p[2]][j+p[3]] = Math.min(dp[i+p[2]][j+p[3]],  dp[i][j] + p[4]);                 
                    }
                }
            }
        }        
        int answer = 999999999;
        for(int i = maxAlp; i < 501; i++){
            for(int j = maxCop; j < 501; j++){
                answer = Math.min(dp[i][j], answer);
            }
        }
        
        return answer;
    }

}