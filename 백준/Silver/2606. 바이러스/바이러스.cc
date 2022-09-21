#include <iostream>
#include <queue>
using namespace std;

int N, M, cnt = 0;
int visited[101] = {0, };
queue<int> q;
bool arr[101][101] = {0, };

void init(){
	
	int tmp1, tmp2;
	
	cin >> N >> M;
	
	for(int i = 0; i < M; i++){
		cin >> tmp1 >> tmp2;	
		arr[tmp1][tmp2]=true;
        arr[tmp2][tmp1]=true;
	}
}

void bfs(){
	
	q.push(1);
	visited[1] = true;
    
	while(q.empty()!=1){
		int x = q.front();
		q.pop();
		
		for(int i = 1; i <= N; i++){
			if(arr[x][i] == true && visited[i] == 0){
				visited[i] = 1;
				q.push(i);
				cnt++;
			}
			
		}		
	}

}

int main() {
	init();
	bfs();
	cout << cnt;
	return 0;
}