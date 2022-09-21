#include <iostream>

using namespace std;

int N, M;
int board[1025][1025] = {0, };

void init();
void solve();

void init() {
	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			int num;
			cin >> num;

			board[i][j] = num + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
 		}
	}
}

void solve() {
	for (int i = 0; i < M; i++) {
		int x, y, x1, y1;
		cin >> x >> y >> x1 >> y1;

		cout << board[x1][y1] - board[x-1][y1] - board[x1][y-1] + board[x-1][ y-1] << "\n";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}