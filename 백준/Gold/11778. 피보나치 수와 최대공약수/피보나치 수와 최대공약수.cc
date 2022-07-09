#include<iostream>
#include<cstring>

using namespace std;

long long gcd(long long, long long);
void solve();
void multi(long long[][2], long long[][2]);

long long gcd(long long a, long long b) {
	if (b == 0) return a;
	return gcd(b, a % b);
}

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
	long long A, B;
	long long result;
	long long matrix[2][2] = { 1,1,1,0 };
	long long matrix2[2][2] = { 1,0,0,1 };

	cin >> A >> B;

	A = gcd(A, B);
	while (A > 0) {
		if (A % 2 == 1) {
			multi(matrix2, matrix);
		}
		A /= 2;
		multi(matrix, matrix);
	}

	result = matrix2[1][0];

	cout << result;
}

int main() {
	solve();
	return 0;
}
