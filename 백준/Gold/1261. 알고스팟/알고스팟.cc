#include <iostream>
#include <queue>

using namespace std;

queue <pair<int,int>> q;
int M, N;
int maze[101][101];
int dist[101][101];
int dy[] = {0, -1, 0, 1};
int dx[] = {1, 0, -1, 0};

bool isInside(int x, int y){
    return(0<x && x <= M && 0 < y && y <= N);
}


int init(){

    cin >> N >> M;

    for(int i = 1; i <= M; i++){
        for(int j = 1; j <= N; j++){
            scanf("%1d",&maze[i][j]);
            dist[i][j] = 100000000;
        }
    }
    dist[1][1] = 0;
    return 0;
}

int bfs(){

    q.push({1,1});

    while(q.empty() == 0){

        int x = q.front().first; int y = q.front().second;

        q.pop();

        for(int i = 0; i < 4; i++){
            if(isInside(x+dx[i],y+dy[i]) == 1){
                if(maze[x+dx[i]][y+dy[i]] == 1){
                    if(dist[x][y]+1 < dist[x+dx[i]][y+dy[i]]){
                        q.push({x+dx[i],y+dy[i]});
                        dist[x+dx[i]][y+dy[i]] = dist[x][y]+1;
                    }
                }
                else
                    if(dist[x][y] < dist[x+dx[i]][y+dy[i]]){
                        q.push({x+dx[i],y+dy[i]});
                        dist[x+dx[i]][y+dy[i]] = dist[x][y];
                    }
                    
             }
        }
    }
    return 0;
}

int main(){

    init();
    bfs();

    cout <<dist[M][N];
    return 0;
}