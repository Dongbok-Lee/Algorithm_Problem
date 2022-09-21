#include<iostream>
#include<algorithm>

using namespace std;

void init();
void solve(int ,int);

int M, N;
int arr[9];
int answer[9];
int check[9];

void init() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) 
		cin >> arr[i];

	sort(arr, arr + N);
}

void solve(int x, int len) {
	if (len == M) {
		for (int i = 0; i < M; i++)
			cout << answer[i] << " ";
		cout << "\n";
		return;
	}

	int tmp = -1;
	for (int i = 0; i < N; i++) {
		if (!check[i] && tmp != arr[i]) {
			tmp = arr[i];
			answer[len] = arr[i];
			check[i] = true;
			solve(i, len + 1);
			check[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cout.tie(0);
	init();
	solve(0, 0);
	return 0;
}