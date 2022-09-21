#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int R, C, answer;
char board[21][21];
bool visited[27];

int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};

void input(){
    
    cin >> R >> C;
    
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cin >> board[i][j];
        }
    }
}

void dfs(int x, int y, int cnt){

    answer = max(answer, cnt);

    for(int i = 0; i < 4; i++){
        
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx >= 0 && ny >= 0 && nx < R && ny < C){
            
            if(visited[board[nx][ny] - 'A'] == false){
                
                visited[board[nx][ny] - 'A'] = true;
                dfs(nx, ny, cnt +1);
                visited[board[nx][ny] - 'A'] = false;

            }
        }
    }
}

void solution(){
    visited[board[0][0] - 'A'] = true;
    dfs(0,0,1);

    cout << answer;
}

void solve(){
    input();
    solution();
}

int main(){

    solve();

    return 0;
}