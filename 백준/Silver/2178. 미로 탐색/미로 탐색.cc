#include <iostream>
#include <queue>
using namespace std;

int result, N,M = 0;
int graph[101][101];
int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};
struct maze{
	int x,y;	
};
queue<maze> q;

bool IsInside(int nx, int ny){
	return(0<=nx && 0<=ny && nx<N && ny<M);
}

void bfs(){
	while(!q.empty()){
		int x = q.front().x;
		int y = q.front().y;
		q.pop();
		
		for(int i = 0; i < 4; i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(graph[nx][ny] == 1 && IsInside(nx,ny) == 1){
				graph[nx][ny] = graph[x][y]+1;
				q.push({nx,ny});
			}
		}
	}
}

int main() {
	cin >> N >> M;
	for(int i = 0; i<N; i++){
		for(int j = 0; j<M; j++){
			scanf("%1d",&graph[i][j]);
		}
	}
	q.push({0,0});
	bfs();
	
	cout << graph[N-1][M-1];
	return 0;
}