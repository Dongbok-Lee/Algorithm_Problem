#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
int result = 0;
int board[501][501] = {0, };

void init();
void solve();
void bruteforce(int, int);
bool is_inside(int, int);

void init() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}
}

void solve() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			bruteforce(i, j);
		}
	}
	cout << result;
}

void bruteforce(int x, int y) {
	int sum = 0, sum1 = 0;
	for (int i = 0; i < 4; i++) {
		if (is_inside(x, y + i))
			sum += board[x][y + i];

		if (is_inside(x + i, y))
			sum1 += board[x + i][y];
	}
	result = max(result, sum);
	result = max(result, sum1);
	//일자로 연결된 테트로미노
	if (is_inside(x + 1, y) && is_inside(x, y + 1) && is_inside(x + 1, y + 1)) {
		sum = 0;
		sum += board[x + 1][y] + board[x][y + 1] + board[x][y] + board[x + 1][y + 1];
		result = max(result, sum);
	}
	// 주먹으로 연결된 테트로미노

	if (is_inside(x + 2, y) && is_inside(x+1, y) && is_inside(x+2, y + 1)) {
		sum = 0;
		sum += board[x + 2][y] + board[x + 1][y] + board[x][y] + board[x + 2][y + 1];
		result = max(result, sum);
	}
	//아래로 긴 니은
	if (is_inside(x + 2, y) && is_inside(x + 1, y) && is_inside(x + 2, y - 1)) {
		sum = 0;
		sum += board[x + 2][y] + board[x + 1][y] + board[x][y] + board[x + 2][y - 1];
		result = max(result, sum);
	}
	//아래로 긴 반대니은
	if (is_inside(x, y + 1) && is_inside(x, y + 2) && is_inside(x + 1, y + 2)) {
		sum = 0;
		sum += board[x][y + 1] + board[x][y+2] + board[x][y] + board[x + 1][y + 2];
		result = max(result, sum);
	}
	//옆으로 긴 기역
	if (is_inside(x, y + 1) && is_inside(x, y + 2) && is_inside(x + 1, y)) {
		sum = 0;
		sum += board[x][y + 1] + board[x][y + 2] + board[x][y] + board[x + 1][y];
		result = max(result, sum);
	}
	//옆으로 긴 반대기역
	if (is_inside(x, y+1) && is_inside(x+2, y + 1) && is_inside(x + 1, y + 1)) {
		sum = 0;
		sum += board[x][y + 1] + board[x + 2][y + 1] + board[x][y] + board[x + 1][y + 1];
		result = max(result, sum);
	}
	//아래로 긴 기역
	if (is_inside(x, y + 1) && is_inside(x + 2, y) && is_inside(x + 1, y)) {
		sum = 0;
		sum += board[x][y + 1] + board[x + 2][y] + board[x][y] + board[x + 1][y];
		result = max(result, sum);
	}
	//아래로 긴 반대기역
	if (is_inside(x + 1, y + 1) && is_inside(x + 1, y + 2) && is_inside(x + 1, y)) {
		sum = 0;
		sum += board[x + 1][y + 1] + board[x + 1][y + 2] + board[x][y] + board[x + 1][y];
		result = max(result, sum);
	}
	//옆으로 긴 니은
	if (is_inside(x + 1, y) && is_inside(x + 1, y - 2) && is_inside(x + 1, y - 1)) {
		sum = 0;
		sum += board[x + 1][y] + board[x + 1][y - 2] + board[x][y] + board[x + 1][y - 1];
		result = max(result, sum);
	}
	//옆으로 긴 반대니은
	//니은자로 연결된 테트로미노
	if (is_inside(x + 1, y) && is_inside(x + 1, y + 1) && is_inside(x + 2, y + 1)) {
		sum = 0;
		sum += board[x + 1][y] + board[x + 1][y + 1] + board[x][y] + board[x + 2][y + 1];
		result = max(result, sum);
	}
	if (is_inside(x + 1, y) && is_inside(x + 1, y - 1) && is_inside(x + 2, y - 1)) {
		sum = 0;
		sum += board[x + 1][y] + board[x + 1][y - 1] + board[x][y] + board[x + 2][y - 1];
		result = max(result, sum);
	}
	//세로로 긴 지그재그
	if (is_inside(x, y + 1) && is_inside(x + 1, y + 1) && is_inside(x + 1, y + 2)) {
		sum = 0;
		sum += board[x][y + 1] + board[x + 1][y + 1] + board[x][y] + board[x + 1][y + 2];
		result = max(result, sum);
	}
	if (is_inside(x, y + 1) && is_inside(x - 1, y + 1) && is_inside(x - 1, y + 2)) {
		sum = 0;
		sum += board[x][y + 1] + board[x - 1][y + 1] + board[x][y] + board[x - 1][y + 2];
		result = max(result, sum);
	}
	//가로로 긴 지그재그

	//지그재그로 연결된 테트로미노

	if (is_inside(x, y + 1) && is_inside(x , y + 2) && is_inside(x - 1, y + 1)) {
		sum = 0;
		sum += board[x][y + 1] + board[x][y + 2] + board[x][y] + board[x -1][y + 1];
		result = max(result, sum);
	}
	//엿모양
	if (is_inside(x, y + 1) && is_inside(x, y + 2) && is_inside(x + 1, y + 1)) {
		sum = 0;
		sum += board[x][y + 1] + board[x][y + 2] + board[x][y] + board[x + 1][y + 1];
		result = max(result, sum);
	}
	//아래엿모양
	if (is_inside(x+1, y) && is_inside(x+2, y) && is_inside(x + 1, y + 1)) {
		sum = 0;
		sum += board[x+1][y] + board[x+2][y] + board[x][y] + board[x + 1][y + 1];
		result = max(result, sum);
	}
	//왼쪽엿모양
	
	if (is_inside(x + 1, y) && is_inside(x + 2, y) && is_inside(x + 1, y - 1)) {
		sum = 0;
		sum += board[x + 1][y] + board[x + 2][y] + board[x][y] + board[x + 1][y - 1];
		result = max(result, sum);
	}
	//오른쪽엿모양
}

bool is_inside(int x, int y) {
	if (x < 0 || x >= N)
		return false;
	if (y < 0 || y >= M)
		return false;
	return true;
}

int main() {
	ios::sync_with_stdio(false);
	cout.tie(0); cin.tie(0);
	init();
	solve();
	return 0;
}