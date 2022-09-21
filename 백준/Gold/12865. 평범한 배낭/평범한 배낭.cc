#include <iostream>
#include<algorithm>

using namespace std;

int N, K;
int weight[101];
int cost[101];
int dp[101][1000001];

void init();
void solve();

void init() {
	cin >> N >> K;

	for (int i = 1; i <= N; i++) 
		cin >> weight[i] >> cost[i];
}

void solve() {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= K; j++) {
			if (j >= weight[i]) dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]]+cost[i]);
			else dp[i][j] = dp[i - 1][j];
		}
	}
	cout << dp[N][K];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}