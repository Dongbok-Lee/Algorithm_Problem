#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int N;
int tmp;
int x, y, z;
int Max[3] = {0,};
int Min[3] = {0,};
void init();
void solve();

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x >> y >> z;

		solve();
	}
}

void solve() {
	int M1, M2, M3;
	int m1, m2, m3;
	M1 = max(x + Max[0], x + Max[1]);
	m1 = min(x + Min[0], x + Min[1]);

	M2 = max(max(y+Max[0], y+Max[1]), y + Max[2]);
	m2 = min(min(y + Min[0], y + Min[1]), y + Min[2]);

	M3 = max(z + Max[1], z + Max[2]);
	m3 = min(z + Min[1], z + Min[2]);

	Max[0] = M1; Max[1] = M2; Max[2] = M3;
	Min[0] = m1; Min[1] = m2; Min[2] = m3;
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();

	cout << max(max(Max[0], Max[1]), Max[2]) << " " << min(min(Min[0], Min[1]), Min[2]);

	return 0;
}//2022-01-31 solved
