#include <iostream>
#include <queue>

using namespace std;

struct location
{
	int x,y;
};

int N;
int land = 0;
int landDistance= 1001;
int map[101][101];
int visited[101][101] = {};
int nx[4] = {1,0,-1,0};
int ny[4] = {0,-1,0,1};
queue<location> q;
bool isInside(int nx, int ny){
	return (0<=nx && 0<=ny && nx<N && ny<N);
}
int dfs(int vx, int vy){

	visited[vx][vy] = 1;
	map[vx][vy] = land;

	for(int i = 0; i < 4; i++){

		int dx = vx+nx[i];
		int dy = vy+ny[i];

		if(map[dx][dy] != 0 && isInside(dx,dy) == 1 && visited[dx][dy] == 0){
			dfs(dx,dy);
		}
	}
    return 0;
}

void bfs(){
	for(int i = 1; i <= land; i++){

		int graph[101][101] = {};

		for(int j = 0; j < N; j++){
			for(int k = 0; k < N; k++){
				if(map[j][k] == i){
					q.push({j,k});
				}
			}
		}

		while(!q.empty()){
			int x = q.front().x;
			int y = q.front().y;
			
			q.pop();

			for(int l = 0; l < 4; l++){
				int xx = x+nx[l];
				int yy = y+ny[l];

				if(map[xx][yy] == 0 && graph[xx][yy] == 0 && isInside(xx,yy) == 1){
					graph[xx][yy] = graph[x][y]+1;
					q.push({xx,yy});
				}else if(map[xx][yy] != i && map[xx][yy] != 0 && isInside(xx,yy)==1){
					if(landDistance > graph[x][y]){
						landDistance = graph[x][y];
					}
				}
			}
		}
	}
}

int main() {
	cin >> N; 

	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			cin >> map[i][j];
		}
	}

	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			if(visited[i][j] == 0 && map[i][j] == 1){
				land++;
				dfs(i,j);
			}
		}
	}

	bfs();
	cout << landDistance;	
}