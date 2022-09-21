#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

int N;
int arr[1001][3] = {0, };
void init();
void solve();

void init() {
	cin >> N;

}

void solve() {
	for (int i = 1; i <= N; i++) {
		int red, green, blue;
		cin >> red >> green >> blue;
		arr[i][0] = min(arr[i-1][1], arr[i-1][2]) + red;
		arr[i][1] = min(arr[i-1][0], arr[i-1][2]) + green;
		arr[i][2] = min(arr[i-1][0], arr[i-1][1]) + blue;
	}
	cout << min(arr[N][0], min(arr[N][1], arr[N][2]));
}

int main() {
	init();
	solve();
	return 0;
}