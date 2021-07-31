#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int N, K;
int result;
int visited[1000001] = {};

queue<pair<int, int>> q;

int bfs(){
    while(q.front().first != K){

        pair<int, int> a = q.front();

        q.pop();

        if(visited[a.first + 1] == 0){
            q.push({a.first+1,a.second+1});
            visited[a.first+1] = 1;
        }
        if(a.first > 0 && visited[a.first - 1] == 0){
            q.push({a.first-1,a.second+1});
            visited[a.first-1] = 1;
        }
        if(a.first < 200000 && visited[a.first * 2] == 0){
            q.push({a.first*2,a.second+1});
            visited[a.first*2] = 1;
        }
    }

    result = q.front().second;
    return 0;
}

int main(){
    
    cin >> N >> K;

    q.push({N,0});
    visited[N] = 1;

    bfs();

    cout << result;
    return 0;
}
//2021-07-31 solved
