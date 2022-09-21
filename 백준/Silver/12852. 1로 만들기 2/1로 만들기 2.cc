#include<iostream>
#include<vector>

using namespace std;

pair<int, int> dp[1000001]{ {0,0}, {1,1}};
int N;

void solve();

void solve() {
	cin >> N;

	for (int i = 1; i < 1000000; i++) {
		if (dp[i + 1].second == 0 || dp[i+1].second > dp[i].second) {
			dp[i + 1].second = dp[i].second + 1;
			dp[i + 1].first = i;
		}
		if (i * 2 <= 1000000) {
			if (dp[i * 2].second == 0 || dp[i * 2].second > dp[i].second) {
				dp[i * 2].second = dp[i].second + 1;
				dp[i * 2].first = i;
			}
		}
		if (i * 3 < 1000000) {
			if (dp[i * 3].second == 0 || dp[i * 3].second > dp[i * 3].second) {
				dp[i * 3].second = dp[i].second + 1;
				dp[i * 3].first = i;
			}
		}
	}
	cout << dp[N].second - 1 << "\n";
	cout << N << " ";
	while (N != 1) {
		cout << dp[N].first << " ";
		N = dp[N].first;
	}
}

int main() {
	solve();
	return 0;	
}