#include <iostream>
#include <algorithm>

using namespace std;

int N, M, total_cost;
int cost[101] = {0,};
int memory[101] = { 0, };
int dp[101][10001] = {0, };

void init();
void solve();

void init() {
	cin >> N >> M;

	for (int i = 1; i <= N; i++) cin >> memory[i];
	for (int i = 1; i <= N; i++) {
		cin >> cost[i]; 
		total_cost += cost[i];
	}
	return;
}

void solve() {
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j <= total_cost; j++) {
			if (j - cost[i] >= 0)
				dp[i][j] = max(dp[i][j], dp[i - 1][j - cost[i]] + memory[i]);

			dp[i][j] = max(dp[i][j], dp[i - 1][j]);
		}
	}

	for (int i = 0; i <= total_cost; i++){
		if (dp[N][i] >= M){
			cout << i;
			break;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}