#include <iostream>
#include <string>
#include <stack>

using namespace std;

int N, cnt = 1;
stack<int> s;
string pm;
void init();
void solve();

void init() {
	cin >> N;
}

void solve() {
	for(int i = 0; i < N; i ++){
		int num;
		cin >> num;

		if (!s.empty() && num <= s.top()) {
			if (num == s.top()) {
				s.pop();
				pm += "-";
			}
			else {
				cout << "NO\n";
				return;
			}
		}
		else {
			while (cnt != num+1) {
				s.push(cnt);
				cnt++;
				pm += "+";
			}
			s.pop();
			pm += "-";
		}
	}

	for (int i = 0; i < pm.size(); i++) {
		cout << pm[i] << "\n";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();

	return 0;
}