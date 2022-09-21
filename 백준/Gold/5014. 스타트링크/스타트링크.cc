#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int F,S,G,U,D;
int result = -1;
bool visited[1000001];
bool is_inside(int x){
    return (0<x && x<=F);
}
queue<pair<int,int>> q;


int bfs(){
    
    q.push({S,0});
    visited[S] = 1;

    while(q.empty() == 0){
         
        pair<int,int> a = q.front();

        if(a.first == G){
            result = a.second;
            return 0;
        }
        q.pop();

        if(is_inside(a.first+U) == 1 && visited[a.first + U] == 0){
            visited[a.first + U] = 1;
            q.push({a.first + U, a.second+1});
        }
        if(is_inside(a.first - D) == 1 && visited[a.first - D] == 0){
            visited[a.first - D] = 1;
            q.push({a.first - D, a.second+1});
        }
    }
    return 0;
}

int main(){

    cin >> F >> S >> G >> U >> D;

    bfs();

    if(result != -1)
        cout << result;
    else
        cout << "use the stairs";
    return 0;
}