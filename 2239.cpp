#include<iostream>
#include<algorithm>

using namespace std;

int board[9][9] = {0,};
bool finish = false;

void init();
void solve();
void dfs(int, int);
bool chk_overlap(int, int, int);
pair<int, int> next_index(int, int);

void init() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
}

void solve() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (board[i][j] == 0) {
				dfs(i, j);
				return;
			}
		}
	}
}

void dfs(int x, int y) {
	if (finish) return;

	if (x == 9 && y == 0) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << board[i][j];
			}
			cout << "\n";
		}
		finish = true;
		return;
	}


	if (board[x][y] == 0) {
		for (int k = 1; k <= 9; k++) {
			if (chk_overlap(x, y, k)) {
				board[x][y] = k;
				dfs(next_index(x, y).first, next_index(x, y).second);
				board[x][y] = 0;
			}
		}
	}
	else {
		dfs(next_index(x, y).first, next_index(x, y).second);
	}
}

bool chk_overlap(int x, int y, int k) {

	for (int i = 0; i < 9; i++) {
		if (board[x][i] == k || board[i][y] == k) return false;
	}

	int section_x = (x / 3) *3; 
	int section_y = (y / 3) *3;

	for (int i = section_x; i <= section_x + 2; i++) {
		for (int j = section_y; j <= section_y + 2; j++) {
			if (board[i][j] == k) return false;
		}
	}

	return true;
}

pair<int, int> next_index(int x, int y) {
	return  (y == 8)  ? make_pair(x+1, 0) : make_pair(x, y + 1);
}

int main() {
	init();
	solve();
	return 0;
}//2022-02-25 solved
