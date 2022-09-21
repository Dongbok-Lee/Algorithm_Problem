#include<iostream>

using namespace std;

int N, M;
int sum[100001];

void init();
void solve();

void init() {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		cin >> sum[i];
		sum[i] += sum[i - 1];
	}
}

void solve() {
	for (int i = 0; i < M; i++) {
		int a, b;

		cin >> a >> b;

		cout << sum[b] - sum[a-1] << "\n";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}