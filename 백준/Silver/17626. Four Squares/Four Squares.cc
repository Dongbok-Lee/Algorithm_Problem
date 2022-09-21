#include <iostream>
#include <algorithm>
#include <string.h>

using namespace std;

int summ[50001];

void solve();

void solve(){
	int N;

	for (int i = 0; i < 50001; i++) {
		summ[i] = 1000;
	}

	cin >> N;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j*j <= i; j++) {
			if (j * j == i)
				summ[i] = 1;
			else
				summ[i] = min(summ[i], summ[i - (j * j)] + summ[j * j]);
		}
	}

	cout << summ[N];
}

int main() {
	solve();
	return 0;
}