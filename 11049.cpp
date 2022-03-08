#include<iostream>
#include<algorithm>

using namespace std;

int N, r, c;
int board[501][2] = { 0, };
int dp[501][501] = { 0, };

void init();
void solve();

void init() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> r >> c;
		board[i][0] = r; board[i][1] = c;
	}

}

void solve() {
	for (int i = 1; i < N; i++) {
		for (int j = 1; j+i <= N; j++) {
			dp[j][i + j] = 2000000000;
			for (int k = j; k < i+j; k++) {
				dp[j][i + j] = min(dp[j][i + j], dp[j][k] + dp[k+1][i+j] + board[j][0] * board[k][1] * board[i + j][1]);
			}
		}
	}
	cout << dp[1][N];
}

int main() {
	init();
	solve();

	return 0;
}//2022-03-08 solved
