#include<iostream>

using namespace std;

int N, M;
int arr[2001] = {0, };
bool dp[2001][2001] = {0, };

void init();
void solve();

void init() {
	cin >> N;
	for (int i = 1; i <= N; i++)
		cin >> arr[i];

	solve();

	cin >> M;
	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		cout << dp[x][y] << "\n";
	}
}

void solve() {

	for (int i = 1; i <= N; i++) {
		dp[i][i] = 1;
		if (arr[i] == arr[i + 1] && i < N)
			dp[i][i + 1] = 1;
	}
		

	for (int i = 1; i <= N; i++) {
		int range = 1;
		
		while (i - range > 0 && i + range <= N) {


			if (arr[i-range] == arr[i+range] && dp[i-range+ 1][i+range - 1] == 1)
				dp[i-range][i+range] = true;

			range++;
		}
		range =  1;
		while (i - range > 0 && i + range+1 <= N) {


			if (arr[i - range] == arr[i + range +1] && dp[i - range + 1][i + range] == 1)
				dp[i - range][i + range+1] = true;

			range++;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();

	return 0;
}//2022-03-07 solved
