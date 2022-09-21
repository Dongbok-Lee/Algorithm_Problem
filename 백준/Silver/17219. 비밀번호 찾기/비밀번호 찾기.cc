#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <map>
#include <string>

using namespace std;

int M, N;
map<string, string> m;

void init();
void solve();

void init() {
	cin >> M >> N;

	for (int i = 0; i < M; i++) {
		string address;
		string password;
		cin >> address >> password;
		m[address] = password;
	}
}

void solve() {
	for (int i = 0; i < N; i++) {
		string address;
		cin >> address;
		cout << m[address] << "\n";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}