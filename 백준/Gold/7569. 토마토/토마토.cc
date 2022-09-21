#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;

int box[101][101][101] = {0, };
int dist[101][101][101] = { 0, };
int M, N, H, result;
int dir_x[6] = { 1, 0, 0, -1, 0, 0 }; 
int dir_y[6] = { 0, 1, 0, 0, -1, 0 }; 
int dir_h[6] = { 0, 0, 1, 0, 0, -1 }; 
queue<pair<int, pair<int, int>>> q;

void init();
void solve();
bool is_inside(int, int, int);

void init() {
	cin >> M >> N >> H;
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 1) {
					q.push({ i,{j,k} });
					dist[i][j][k] = 1;
				}
			}
		}
	}
}

void solve() {
	while (!q.empty()) {
		int cur_h = q.front().first;
		int cur_y = q.front().second.first;
		int cur_x = q.front().second.second;

		q.pop();

		for (int i = 0; i < 6; i++) {
			int next_h = cur_h + dir_h[i];
			int next_y = cur_y + dir_y[i];
			int next_x = cur_x + dir_x[i];

			if (is_inside(next_x, next_y, next_h)) {
				if (box[next_h][next_y][next_x] == 0) {
					q.push({ next_h,{next_y, next_x} });
					box[next_h][next_y][next_x] = 1;
					dist[next_h][next_y][next_x] = dist[cur_h][cur_y][cur_x] + 1;
				}
			}
		}
	}

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				result = max(result, dist[i][j][k]);
				if (box[i][j][k] == 0) {
					cout << -1;
					return;
				}
			}
		}
	}
	cout << result - 1;
}

bool is_inside(int x, int y, int h) {
	if (x < 0 || x >= M)
		return false;

	if (y < 0 || y >= N)
		return false;
	
	if (h < 0 || h >= H)
		return false;

	return true;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}