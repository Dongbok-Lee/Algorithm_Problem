#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string str1 = " ";
string str2 = " ";
int dp[1001][1001] = {0,};

void init();
void solve();

void init() {
	string tmp1, tmp2;
	cin >> tmp1 >> tmp2;
	str1 += tmp1; str2 += tmp2;
	return;
}

void solve() {
	for (int i = 1; i < str1.size(); i++) {
		for (int j = 1; j < str2.size(); j++) {
			if (str1[i] == str2[j])
					dp[i][j] = dp[i - 1][j - 1]+1;

			else 
					dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
		}
	}

	cout << dp[str1.size()-1][str2.size()-1];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}//2022-03-02 solved
