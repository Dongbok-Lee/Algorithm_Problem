#include<iostream>

using namespace std;

int N;
int W[11][11];
int visited[11] = {};
int result = 1000000000;

int dfs(int n, int x, int tmp){
    
     if(x == N && W[n][0] !=0){
        tmp += W[n][0];
        result =  min(result,tmp);
        return 0;
    }   

    visited[n] = 1;

    for(int i = 0; i < N; i++){
        if(visited[i] == 0 && i != n && W[n][i] != 0){
            tmp += W[n][i];
            dfs(i, x+1, tmp);
            tmp -= W[n][i];
            visited[i] = 0;
        }
    }
      
    return 0;
}

int main(){

    cin >> N;

    for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) cin >> W[i][j];
    
    dfs(0, 1 ,0);

    cout << result;
}
//2021-07-31 solved
