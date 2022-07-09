#include <iostream>
using namespace std;

void init();
int solve(int, int ,int);
int move(int, int);
int cnt = 0;
int arr[100001];
int dp[5][5][100000];

void init() {
	cin >> arr[cnt];
	while (arr[cnt] != 0) {
		cnt++;
		cin >> arr[cnt];
	}
}

int solve(int l, int r, int n) {
	if (cnt == n) return 0;

	if (dp[l][r][n] != 0) return dp[l][r][n];
	return dp[l][r][n] = min(move(l, arr[n]) + solve(arr[n], r, n + 1), move(r, arr[n]) + solve(l, arr[n], n + 1));
}

int move(int from, int to) {
	if (from == to) return 1;
	switch (from) {
		case 0: return 2;
		case 1: return to == 3 ? 4 : 3;
		case 2: return to == 4 ? 4 : 3;
		case 3: return to == 1 ? 4 : 3;
		case 4: return to == 2 ? 4 : 3;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	init();
	cout << solve(0, 0, 0);
	return 0;
}