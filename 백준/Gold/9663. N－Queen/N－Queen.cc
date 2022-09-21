#include <iostream>

using namespace std;

int N, result = 0;
int board[15];

void init();
void solve();
void dfs(int);
bool chk_overlap(int);

void init() {
	cin >> N;
}

void solve() {
	dfs(0);
	cout << result;
}

void dfs(int index) {
	if (index == N)
		result++;
	else {
		for (int i = 0; i < N; i++) {
			board[index] = i;
			if (chk_overlap(index))
				dfs(index + 1);
		}
	}
}

bool chk_overlap(int index) {
	for (int i = 0; i < index; i++) {
		if (board[i] == board[index] || abs(board[index] - board[i]) == index - i)
			return false;
	}
	return true;
}

int main() {
	init();
	solve();
	return 0;
}