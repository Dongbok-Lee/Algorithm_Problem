#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N, M;
bool board[101][101];
int melt_score[101][101];
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { -1, 1, 0, 0 };
int result = 0;
queue<pair<int, int>> q;


void init();
void solve();
bool is_inside(int, int);

void init() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
			cin >> board[i][j];
	}
}

void solve() {
	int remove = 1;
	
	while (remove) {

		int visited[101][101] = {0,};
		remove = 0;

		q.push({ 0,0 });
		visited[0][0] = true;

		while (!q.empty()) {
			int cur_x = q.front().first;
			int cur_y = q.front().second;
			q.pop();

			//녹는 치즈인지 검사
			for (int i = 0; i < 4; i++) {
				int next_x = cur_x + dx[i];
				int next_y = cur_y + dy[i];
				
				if (is_inside(next_x, next_y)) {
					if (board[next_x][next_y] == true) {
						melt_score[next_x][next_y]++;
					}
					else if (!visited[next_x][next_y]) {
						q.push({ next_x,next_y });
						visited[next_x][next_y] = true;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (melt_score[i][j] > 1) {
					board[i][j] = 0;
					remove++;
				}
				melt_score[i][j] = 0;
			}
		}
		result++;
	}
	cout << result-1;
}

bool is_inside(int x, int y) {
	if (x < 0 || x >= N)
		return false;
	if (y < 0 || y >= M)
		return false;

	return true;
}

int main() {
	init();
	solve();
	return 0;
}
