#include <iostream>

using namespace std;

void init();
void solve();

int N, B, C;
int Class[1000000];

void init() {
	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> Class[i];

	cin >> B >> C;
}

void solve() {
	long long result = N;
	for (int i = 0; i < N; i++) {
		if (Class[i] - B > 0) {
			result += (Class[i] - B) / C;
			if ((Class[i] - B) % C != 0)
				result++;
		}
	}
	cout << result;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	init();
	solve();
	return 0;
}