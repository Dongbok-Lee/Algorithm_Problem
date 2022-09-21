#include<iostream>
using namespace std;

int N;
int field[26][26] = {}, visited[26][26] = {};
int count[1000] = {};
int tmp = 0;
int num = 0;
int dfs(int v, int s){
 if(visited[s][v] == 1)
 	return 0;
 visited[s][v] = 1;
 if(field[s][v] == 1){
 	tmp++;
 	if(v+1 < N)
 		dfs(v+1,s);
 		
 	if(v > 0)
 		dfs(v-1,s);
 	if(s > 0)
 		dfs(v,s-1);
 	if(s+1 < N)
 		dfs(v,s+1);
 }
 return 0;
}
int main(){
    
    cin >> N;
    
    for(int i = 0; i < N; i++){
    	for(int j = 0; j < N; j++){
    		scanf("%1d",&field[i][j]);
    	}
    }
    
    for(int i = 0; i < N; i++){
    	for(int j = 0; j < N; j++){
    		if(visited[i][j] == 0){
    			dfs(j,i);
    			if(tmp != 0){
    				count[tmp]++;
    				num++;
    			}
    			tmp = 0;
    		}
    	}
    }
    cout << num << "\n";
    
    for(int i = 0; i < 700; i++){
    	if(count[i] != 0){
    		while(count[i] != 0){
    			cout << i << "\n";
    			count[i]--;
    		}
    	}
    }
    
}