#include<iostream>
#include<cstring>
#define INF 987654321

using namespace std;

void solve();
void multi(long long[][2], long long[][2]);

void multi(long long m1[][2], long long m2[][2]) {
	long long tmp[2][2];
	long long temp;

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			temp = 0;
			for (int k = 0; k < 2; k++) {
				temp += m1[i][k] * m2[k][j];
			}
			tmp[i][j] = temp % 1000000007;
		}
	}

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			m1[i][j] = tmp[i][j];
}

void solve() {
	long long N;
	long long matrix[2][2] = { 1,1,1,0 };
	long long matrix2[2][2] = { 1,0,0,1 };
	cin >> N;

	while (N > 0) {
		if (N % 2 == 1) {
			multi(matrix2, matrix);
		}
		N /= 2;
		multi(matrix, matrix);
	}

	cout << matrix2[1][0];
}

int main() {
	solve();
	return 0;
}

