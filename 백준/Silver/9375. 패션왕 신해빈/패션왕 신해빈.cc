#include<iostream>
#include<map>

using namespace std;

int T, N;

void solve();

void solve() {
	cin >> N;
	map<string, int> m;
	int result = 1;

	for (int i = 0; i < N; i++) {
		string tmp;
		cin >> tmp >> tmp;
		
		if (m.find(tmp) == m.end()) {
			m[tmp] = 1;
		}
		else {
			m[tmp]++;
		}
	}

	for (auto iter : m) {
		result *= (iter.second+1);
	}
	cout << result - 1<<"\n";
}

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		solve();
	}
	
	return 0;
}