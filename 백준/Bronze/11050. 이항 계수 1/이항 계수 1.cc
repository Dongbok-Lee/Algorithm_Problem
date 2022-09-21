#include <iostream>
#include <algorithm>

using namespace std;


int N, K;

void init();
void solve();
int factorial(int);

void init() {
	cin >> N >> K;
}

void solve() {
	cout << factorial(N) / (factorial(K) * factorial(N - K));
}

int factorial(int n) {
	if (n == 1 || n == 0) {
		return 1;
	}
	else {
		return(factorial(n - 1) * n);
	}
}

int main() {
	init();
	solve();
	return 0;
}