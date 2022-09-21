#include<iostream>
#include<vector>
#include<deque>
#include<string>

using namespace std;

int N, M, result = 0;
string s;

void init();
void solve();

void init() {
	cin >> N >> M >> s;
}

void solve() {
	int cnt = 0;
	for (int i = 2; i < s.size(); i++) {
		if (s[i] == 'I') {
			if (s[i - 2] == 'I' && s[i - 1] == 'O') {
				i++;
				cnt++;
				if (cnt >= N)
					result++;
			}
			else
				cnt = 0;
		}
		else
			cnt = 0;
	}

	cout << result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}