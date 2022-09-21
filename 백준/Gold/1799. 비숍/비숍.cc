#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int N, result;
vector<pair<int, int>> v;
vector<pair<int, int>> v2;
int board[10][10] = {0,};
int direction[4][2] = { {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };

void init();
void solve();
void dfs(int, int, vector<pair<int, int>>);
bool chk_bishop(int, int);
bool is_inside(int);

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int num;
			cin >> num;
			board[i][j] = num;

			if (num == 1) {
				if (((i + j) % 2) == 1) v.push_back({ i, j });
				else v2.push_back({ i, j });
			}
		}
	}
}

void solve() {

	for (int i = 0; i < v.size(); i++) dfs(i, 0, v);
	
	int tmp = result;
	result = 0;
	for (int i = 0; i < v2.size(); i++) dfs(i, 0, v2);

	cout << result + tmp;
}

void dfs(int index, int cnt, vector<pair<int, int>> v ) {

	if (index == v.size()) {
		result = max(cnt,result);
		return;
	}

	int x = v[index].first;
	int y = v[index].second;

	if (chk_bishop(x, y)) {
		board[x][y] = -1;
		dfs(index + 1, cnt + 1, v);
		board[x][y] = 1;
	}

	dfs(index + 1, cnt, v);

	return;
}

bool chk_bishop(int x, int y) {

	for (int i = 1; i < N; i++) {
		for (int j = 0; j < 4; j++) {
			int tmp = x + (direction[j][0] * i);
			int tmp2 = y + (direction[j][1] * i);
			if (is_inside(tmp) && is_inside(tmp2)) {
				if (board[x + (direction[j][0] * i)][y + (direction[j][1] * i)] == -1)
					return false;
			}
		}
	}
	return true;
}

bool is_inside(int x) {
	return (0 <= x && x < N);
}

int main() {
	init();
	solve();

	return 0;
}