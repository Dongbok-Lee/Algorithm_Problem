#include <iostream>
#include <queue>

using namespace std;

int result = 0;
int M,N = 0;
int table[1001][1001];

struct tomato{
	int y,x;
};
queue<tomato> q;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

bool IsInside(int ny, int nx){
	return( 0<=nx && 0<=ny && nx<M && ny<N );
}

void bfs(void){
	while(!q.empty()){
		int y = q.front().y;
		int x = q.front().x;
		q.pop();
		for(int i = 0; i < 4; i++){
			int	nx = x+dx[i];
			int	ny = y+dy[i];
			if(table[ny][nx] == 0 && IsInside(ny,nx) == 1){
				table[ny][nx] = table[y][x]+1;
				q.push({ny,nx});
			}
		}
	}
}
int main() {
	cin >> M >> N;
	for(int i = 0; i < N; i++){
		for(int j = 0; j < M; j++){
			scanf("%d",&table[i][j]);
			if(table[i][j] == 1){
				q.push({i,j});
			}
		}
	}
	
	bfs();
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < M; j++){
			if(table[i][j] == 0){
				printf("-1");
				return 0;
			}
			
			if(result < table[i][j]){
				result = table[i][j];
			}
		}
	}
	
	cout << result-1;
	return 0;
}