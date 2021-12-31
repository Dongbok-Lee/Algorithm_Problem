#include <iostream>
#include <algorithm>

using namespace std;

int N, M;
int card[200];
int index = 0;
int result;

void init();
void solve();

void init() {

	cin >> N >> M;
	result = 0;

	for (int i = 0; i < N; i++) {
		cin >> card[i];
	}
}

void solve() {

	for (int i = 0; i < N - 2; i++) {
		for (int j = i + 1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {
				if (M - card[i] - card[j] - card[k] >= 0 && (M - card[i] - card[j] - card[k] < M - result)) {
					result = card[i] + card[j] + card[k];
				}
			}
		}
	}

	cout << result;
}

int main() {
	init();
	solve();
}//2021-12-30 solved
