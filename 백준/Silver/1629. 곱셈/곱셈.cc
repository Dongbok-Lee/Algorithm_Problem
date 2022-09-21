#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;

long long A, B, C;

void init();
long long solve(long long);

void init() {
	cin >> A >> B >> C;
	A %= C;
}

long long solve(long long b) {
	
	if (b == 0) {
		return 1;
	}
	if (b == 1) {
		return A;
	}
	
	if (b % 2 == 1) {
		return ((solve(b / 2) * solve(b / 2)%C)* A) % C;
	}
	else {
		return (solve( b / 2)* solve(b / 2))%C;
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(); cout.tie();

	init();
	cout << solve(B);
}