#include<iostream>
#include<cstring>

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
			tmp[i][j] = temp % 1000000000;
		}
	}

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			m1[i][j] = tmp[i][j];
}

void solve() {
	long long A, B;
	long long Aresult, Bresult;
	long long Amatrix[2][2] = { 1,1,1,0 };
	long long Amatrix2[2][2] = { 1,0,0,1 };
	long long Bmatrix[2][2] = { 1,1,1,0 };
	long long Bmatrix2[2][2] = { 1,0,0,1 };
	cin >> A >> B;
	A += 1; B += 2;
	while (A > 0) {
		if (A % 2 == 1) {
			multi(Amatrix2, Amatrix);
		}
		A /= 2;
		multi(Amatrix, Amatrix);
	}

	Aresult = Amatrix2[1][0] - 1;



	while (B > 0) {
		if (B % 2 == 1) {
			multi(Bmatrix2, Bmatrix);
		}
		B /= 2;
		multi(Bmatrix, Bmatrix);
	}

	Bresult = Bmatrix2[1][0] - 1;

	cout << (Bresult - Aresult+ 1000000000) % 1000000000;
}

int main() {
	solve();
	return 0;
}
