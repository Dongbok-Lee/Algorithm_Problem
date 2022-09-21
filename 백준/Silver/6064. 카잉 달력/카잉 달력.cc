#include<iostream>
#include<vector>
#include<deque>
#include<string>

using namespace std;

int T;

void solve();
int gcd(int, int);
int lcm(int, int);

void solve() {
	int M, N, x, y, result = 0;

	cin >> M >> N >> x >> y;


	while ((x-1) % N+1 != y) {
		x +=  M;

		if (x > lcm(M,N)) {
			cout << -1 << "\n";
			return;
		}
	}

	cout << x << "\n";
}
int gcd(int a, int b) {
	while (b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}
	return a;
}

int lcm(int a, int b) {
	return a * b / gcd(a, b);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	cin >> T;
	for (int i = 0; i < T; i++) {
		solve();
	}
	return 0;
}