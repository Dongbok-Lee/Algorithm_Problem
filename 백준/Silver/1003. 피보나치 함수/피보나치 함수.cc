#include <iostream>
#include <queue>

using namespace std;

int arr[41][2] = { {1, 0}, {0, 1}, };
int tcase;
int N;

void solve();

void solve() {
	cin >> tcase;

	for (int j = 2; j < 41; j++) {
		arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
		arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
	}
	
	for (int i = 0; i < tcase; i++) {
		cin >> N;
		cout << arr[N][0] << " " << arr[N][1] << "\n";
	}
}

int main() {
	solve();
	return 0;
}