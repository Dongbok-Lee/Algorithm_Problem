#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

void init();
void solve(int, int);

int M, N;
int arr[9];
int answer[9];

void init() {
	cin >> M >> N;

	for (int i = 0; i < M; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + M);
}

void solve(int sort_index, int answer_index) {
	if (answer_index == N) {
		for (int i = 0; i < N; i++)
			cout << answer[i] << " ";
		cout << "\n";
		return;
	}

	for (int i = sort_index; i < M; i++) {
		answer[answer_index] = arr[i];
		solve(i, answer_index + 1);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cout.tie(0);

	init();
	solve(0,0);
	return 0;
}
