#include<iostream>
#include<queue>
#include<algorithm>
#include<cmath>
using namespace std;

void init();
void solve();

int N;

void init() {
	cin >> N;
}

void solve() {
	for (int i = 1; i < N; i++) {
		int num = i;
		int result = i;
		
		while (num != 0) {
			result += num % 10;
			num /= 10;
		}
			
		
		if (result == N) {
			cout << i;
			return;
		}
			
	}
	cout << 0;
}

int main() {
	init();
	solve();

	return 0;
}