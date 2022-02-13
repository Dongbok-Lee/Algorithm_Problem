#include <iostream>

using namespace std;

int dp[105][10][1 << 10];
int n, ans = 0;

void init();
void solve();
int dfs(int ,int, int);

void init() {
	cin >> n;
}

void solve() {

	for (int i = 1; i < 10; i++) {
		ans += dfs(1, i, 1 << i);
		ans %= 1000000000;
	}

	cout << ans;
	return;
}



int dfs(int idx, int num, int bit) {
	
	if (dp[idx][num][bit])
		return dp[idx][num][bit];

	if (idx == n)
		return bit == (1 << 10) - 1 ? 1 : 0;

	long long res = 0;

	if (num + 1 < 10)
		res += dfs(idx + 1, num + 1, bit | 1 << (num + 1));
	if (num - 1 >= 0)
		res += dfs(idx + 1, num - 1, bit | 1 << (num - 1));

	return dp[idx][num][bit] = res %= 1000000000;
		
}

int main() {
	init();
	solve();
	return 0;
}//2022-02-13 solved
