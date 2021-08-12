#include <iostream>
#include <string>
#include<cstring>

using namespace std;

int N, M, K; 
int dp[101][101][81];
char word_table[101][101];   
string word;
int cnt = 0;

bool is_inside(int a, int b){
    return (0<=a && 0<=b && a <N && b < M);
}

int dfs(int a, int b, string c){

    c = c + word_table[a][b];

    if(dp[a][b][c.size()] != -1){
        return 0;
    }

    dp[a][b][c.size()] = 0;

    if(c == word){
        dp[a][b][c.size()] += 1; 
        return 0;
    }
    else if(c[c.size()-1] != word[c.size()-1] ){
        return 0;
    }
    
    for(int i = -K; i <= K; i++){
        if(i !=0){
            if(is_inside(a+i,b)){
                dfs(a+i,b,c);
                if(dp[a+i][b][c.size()+1]!= -1)
                    dp[a][b][c.size()]+=dp[a+i][b][c.size()+1];
            }
            if(is_inside(a,b+i)){
                dfs(a,b+i,c);
                if(dp[a][b+i][c.size()+1]!= -1)
                    dp[a][b][c.size()]+=dp[a][b+i][c.size()+1];
            }
        }
    }
    return 0;
}

int main(){
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    memset(dp,-1,sizeof(dp));
    cin >> N >> M >> K;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> word_table[i][j];
        }
    }

    cin >> word;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            string str;
            dfs(i,j,str);
        }
    }

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cnt += dp[i][j][1];
        }
    }
    cout << cnt;
    return 0;
}
//2021-08-10 solved
