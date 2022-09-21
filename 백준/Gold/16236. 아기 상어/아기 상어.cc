#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int N, ssize = 2, cnt = 2;
int result = 0;
int board[21][21];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };
bool visited[21][21];
pair<pair<int, int>,int> cur;
queue<pair<pair<int, int>, int>> q;

void init();
void solve();
bool is_Empty();
bool is_Inside(int, int);

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			
			cin >> board[i][j];

			if (board[i][j] == 9) {
				cur = { { i, j }, 0 };
				board[i][j] = 0;
			}
				
	
		}
	}
	
}

void solve() {

	while (!is_Empty()) {

		q.push(cur);
		visited[cur.first.first][cur.first.second] = true;
		vector<pair<pair<int, int>, int>> v;

		while (!q.empty()) {
			int cur_x = q.front().first.first;
			int cur_y = q.front().first.second;
			int cur_cost = q.front().second;

			q.pop();

			for (int i = 0; i < 4; i++) {
				int next_x = cur_x + dx[i];
				int next_y = cur_y + dy[i];

				if (is_Inside(next_x, next_y) && visited[next_x][next_y] == false) {
					if (ssize > board[next_x][next_y] && board[next_x][next_y] != 0) {
						v.push_back({ { cur_cost + 1, next_x}, next_y });
						q.push({ {next_x, next_y}, cur_cost + 1 });
					}
					else if (board[next_x][next_y] == 0 || board[next_x][next_y] == ssize)
						q.push({ {next_x,next_y}, cur_cost + 1 });

					visited[next_x][next_y] = true;
				}
			}
		}
		if (v.empty()) {
			cout << result;
			return;
		}

		cnt--;
		if (cnt == 0) 
			cnt = ++ssize;

		sort(v.begin(), v.end());
		cur = { { v[0].first.second, v[0].second },v[0].first.first };
		board[v[0].first.second][v[0].second] = 0;
		memset(visited, false, sizeof(visited));
		result = v[0].first.first;
	}
	cout << result;
}

bool is_Empty() {
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j < 20; j++) {
			if (board[i][j] != 0 && board[i][j] < ssize)
				return false;
		}
	}
	return true;
}

bool is_Inside(int x, int y) {
	if (x < 0 || x >= N)
		return false;
	if (y < 0 || y >= N)
		return false;
	return true;
}

int main() {
	init();
	solve();

	return 0;
}