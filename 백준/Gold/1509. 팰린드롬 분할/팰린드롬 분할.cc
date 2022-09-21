#include<iostream>
#include<cstring>
#include<algorithm>

#define MAX 2510

using namespace std;

int N;
int palindrome[MAX][MAX];
char str[MAX];
int dp[MAX];

void init();
void solve();
void make_Palindrome();

void init() {
	cin >> str + 1;
}

void solve() {
	for (N = 1; str[N] != NULL; N++); N--;

	make_Palindrome();

	for (int end = 1; end <= N; end++) {
		dp[end] = 2e9;
		for (int start = 1; start <= end; start++) {
			if (palindrome[start][end] == true) {
				dp[end] = min(dp[start - 1] + 1, dp[end]);
			}
		}
	}
	cout << dp[N];
}

void make_Palindrome() {

	for (int i = 1; i <= N; i++) {
		palindrome[i][i] = true;
	}

	for (int i = 1; i < N; i++) {
		if (str[i] == str[i + 1]) palindrome[i][i + 1] = true;
	}

	for (int len = 3; len <= N; len++) {
		for (int start = 1; len + start - 1 <= N; start++) {
			int end = start + len - 1;

			if (str[start] == str[end] && palindrome[start + 1][end - 1] == true) {
				palindrome[start][end] = true;
			}
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