#include<iostream>

using namespace std;

int N, cnt = 0, RG_cnt = 0;
int dy[4] = { 1, 0, -1, 0 };
int dx[4] = { 0, 1, 0, -1};
char board[101][101] = { 0, };
char RG_board[101][101] = { 0, };
bool visited[101][101] = { 0, };
bool RG_visited[101][101] = { 0, };

void init();
void solve();
void dfs(int, int);
void RG_dfs(int, int);
bool is_inside(int, int);

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) 
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
			if (board[i][j] == 'R') {
				RG_board[i][j] = 'G';
			}
			else {
				RG_board[i][j] = board[i][j];
			}
		}
}

void solve() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j] == false) {
				visited[i][j] = true;
				cnt++;
				dfs(i, j);
			}
			if (RG_visited[i][j] == false) {
				RG_visited[i][j] = true;
				RG_cnt++;
				RG_dfs(i, j);
			}
		}
	}
	cout << cnt << " " << RG_cnt;
}

void dfs(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int next_x = x + dx[i];
		int next_y = y + dy[i];

		if (is_inside(next_x, next_y) && board[x][y] == board[next_x][next_y] && visited[next_x][next_y] == false){
			visited[next_x][next_y] = true;
			dfs(next_x, next_y);
		}
	}
}

void RG_dfs(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int next_x = x + dx[i];
		int next_y = y + dy[i];

		if (is_inside(next_x, next_y) && RG_board[x][y] == RG_board[next_x][next_y] && RG_visited[next_x][next_y] == false) {
			RG_visited[next_x][next_y] = true;
			RG_dfs(next_x, next_y);
		}
	}
}

bool is_inside(int x, int y) {
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