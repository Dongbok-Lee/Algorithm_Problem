#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
int result = -1;
int table[1001][1001] = { 0, };
bool visited[1001][1001][2] = { 0, };
int dir_x[] = { 0,-1, 0, 1 };
int dir_y[] = { 1, 0, -1, 0 };
queue<pair<pair<int, int>, pair<int, bool>>> q;

void init();
void solve();
bool is_Inside(int,int);

void init() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &table[i][j]);
		}
	}
}

void solve() {
	q.push({ {0,0} ,{1,false} });
	visited[0][0][0] = true;

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int cnt = q.front().second.first;
		int block = q.front().second.second;
		q.pop();

		if (x == N - 1 && y == M - 1) {
			result = cnt;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dir_x[i];
			int ny = y + dir_y[i];

			if (is_Inside(nx, ny)) {
				if (table[nx][ny] == 1 && block == false) {
					visited[nx][ny][1] == true;
					q.push({ {nx, ny} ,{cnt+1,true} });
				}
				else if(table[nx][ny] == 0 && visited[nx][ny][block] == false){
					visited[nx][ny][block] = true;
					q.push({ {nx, ny},{cnt+1, block} });
				}
			}
		}
	}
}

bool is_Inside(int x, int y) {
	return x >= 0 && x < N && y >= 0 && y < M;
}

int main() {

	init();
	solve();

	cout << result;
	return 0;
}