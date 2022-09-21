#include<iostream>
#include<algorithm>

using namespace std;

void init();
void solve(int, int);

int N, M;
int arr[9], answer[9];

void init() {
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		cin >> arr[i];
	sort(arr, arr + N);
	solve(0, 0);
}

void solve(int index, int len) {
	if (len == M) {
		for (int i = 0; i < M; i++)
			cout << answer[i] << " ";
		cout << "\n";
		return;
 	}
	int tmp = -1;
	for (int i = index; i < N; i++) {
		if (tmp != arr[i]) {
			tmp = arr[i];
			answer[len] = arr[i];
			solve(i, len + 1);
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cout.tie(0);
	init();
	return 0;
}