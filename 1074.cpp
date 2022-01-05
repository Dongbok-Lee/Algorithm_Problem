#include <iostream>
#include <algorithm>
#include <queue>
#include<cmath>
#include<cstring>

using namespace std;

void init();
void solve();
int recursion(int,int);

int N, r, c;

void init() {
	cin >> N >> r >> c;
}

void solve() {

	cout << recursion(r,c);
}

int recursion(int rr, int cc) {

	if (N == 0)
		return 0;
	
	int asize = pow(4, N);
	N--;

	int row_size = sqrt(asize);

	if (0 <= rr && rr < row_size / 2 && 0 <= cc && cc < row_size / 2) {
		return recursion(rr,cc);
	}
	else if (row_size / 2 <= rr && rr < row_size && 0 <= cc && cc < row_size / 2) {
		return ((asize / 4) * 2 )  + recursion(rr - (row_size/2), cc);
	}
	else if (row_size / 2 <= rr && rr < row_size && row_size / 2 <= cc && cc < row_size) {
		return ((asize / 4)*3) + recursion(rr - (row_size/2), cc - (row_size / 2));
	}
	else if (0 <= rr && rr < row_size/2 && row_size / 2 <= cc && cc < row_size) {
		return (asize / 4) + recursion(rr, cc - (row_size / 2));
	}
}

int main() {
	init();
	solve();
}//2022.01.02 solved
