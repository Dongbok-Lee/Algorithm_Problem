#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

long long N, B;
long long procession[5][5];
long long answer[5][5];

void init();
void solve();
void multiple_procession(long long [5][5], long long [5][5]);
void print_procession(long long [5][5]);

void init() {

	cin >> N >> B;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> procession[i][j];
			answer[i][i] = 1;
		}
	}
}
void solve() {

	while (B > 0) {

		if (B % 2 == 1) {
			multiple_procession(answer, procession);
			B--;
		}
		B /= 2;

		multiple_procession(procession,procession);
	}
}

void multiple_procession(long long x[5][5], long long y[5][5]) {
	long long tmp[5][5];
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			long long multi = 0;
			for (int k = 0; k < N; k++) {
				multi += x[i][k] * y[k][j];
			}
			tmp[i][j] = multi % 1000;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			x[i][j] = tmp[i][j];
		}
	}

	return;
}

void print_procession(long long tmp[5][5]) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << tmp[i][j] << " ";
		}
		cout << "\n";
	}
}

int main() {
	
	init();
	solve();
	print_procession(answer);
	return 0;
}

