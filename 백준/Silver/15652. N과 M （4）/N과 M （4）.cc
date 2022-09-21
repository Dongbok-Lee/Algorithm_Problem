#include<iostream>
#include<algorithm>

using namespace std;

void init();
void solve(int, int);

int M, N;
int arr[9];

void init() {
	cin >> M >> N;
}

void solve(int x, int y) {
	if (y == N) {
		for (int i = 0; i < N; i++)
			cout << arr[i] << " ";
		cout << "\n";
		return;
	}
	for (int i = x; i <= M; i++) {
		arr[y] = i;
		solve(i, y + 1);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cout.tie(0);
	init();
	solve(1, 0);
	return 0;
}