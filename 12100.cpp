#include<iostream>
#include<queue>
#define MAX 20

using namespace std;

int N, result = 0;
int board[MAX][MAX];

void init();
void solve();
void dfs(int);
void swipe(int);

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}
}

void solve() {
	int cnt = 5;

	dfs(cnt);
}

void dfs(int cnt) {
	if (cnt == 0) {
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = max(result,board[i][j]);
			}
		}
		return;
	}

	int cp_board[MAX][MAX] = {0, };

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cp_board[i][j] = board[i][j];
		}
	}

	for (int i = 0; i < 4; i++)
	{
		swipe(i);
		dfs(cnt - 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = cp_board[i][j];
			}
		}
	}
}

void swipe(int dir) {
	queue<int> q;

	switch (dir) {
	case 0:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j])
					q.push(board[i][j]);
				board[i][j] = 0;
			}

			int index = 0;

			while (!q.empty()) {
				int data = q.front();
				q.pop();

				if (board[i][index] == 0)
					board[i][index] = data;
				else if (board[i][index] == data) {
					board[i][index] *= 2;
					index++;
				}
				else {
					index++;
					board[i][index] = data;
				}
			}
		}
		break;

	case 1:
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (board[i][j])
					q.push(board[i][j]);
				board[i][j] = 0;
			}

			int index = N - 1;

			while (!q.empty()) {
				int data = q.front();
				q.pop();

				if (board[i][index] == 0)
					board[i][index] = data;
				else if (board[i][index] == data) {
					board[i][index] *= 2;
					index--;
				}
				else {
					index--;
					board[i][index] = data;
				}
			}
		}
		break;
	case 2:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[j][i])
					q.push(board[j][i]);
				board[j][i] = 0;
			}

			int index = 0;

			while (!q.empty()) {
				int data = q.front();
				q.pop();

				if (board[index][i] == 0)
					board[index][i] = data;
				else if (board[index][i] == data) {
					board[index][i] *= 2;
					index++;
				}
				else {
					index++;
					board[index][i] = data;
				}
			}
		}
		break;
	case 3:
		for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if (board[j][i])
					q.push(board[j][i]);
				board[j][i] = 0;
			}

			int index = N-1;

			while (!q.empty()) {
				int data = q.front();
				q.pop();

				if (board[index][i] == 0)
					board[index][i] = data;
				else if (board[index][i] == data) {
					board[index][i] *= 2;
					index--;
				}
				else {
					index--;
					board[index][i] = data;
				}
			}
		}
		break;
	}
}

int main() {
	init();
	solve();

	cout << result;
	return 0;
}
//2022-03-13 solved
