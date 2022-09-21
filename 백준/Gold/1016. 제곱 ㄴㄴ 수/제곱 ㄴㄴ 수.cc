#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
using namespace std;

void init();
void solve();

long long number[1000001];

long long Min, Max;
int result = 0;

void init() {
	cin >> Min >> Max;
}

void solve() {
	for (long long i = 2; i * i <= Max; i++) {
		long long n = Min / (i * i);

		if (Min % (i * i))
			n++;

		while (n * i * i <= Max) {
			number[n * i * i - Min] = 1;
			n++;
		}
	}

	for (int i = 0; i <= Max - Min; i++)
		if (number[i] == 0)
			result++;

	cout << result;
}

int main() {
	init();
	solve();
	return 0;
}