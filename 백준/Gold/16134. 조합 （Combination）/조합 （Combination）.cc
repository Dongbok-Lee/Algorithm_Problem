#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
using namespace std;

void init();
long long solve(long long, long long);

long long N, K;
long long arr1[1000001];
long long arr2[1000001];

void init() {
	cin >> N >> K;

	arr1[0] = 1;
	for (int i = 1; i <= 1000000; i++)
		arr1[i] = arr1[i - 1] * i % 1000000007;

	arr2[1000000] = solve(arr1[1000000], 1000000005);
	for (int i = 1000000 - 1; 0 <= i; i--) 
		arr2[i] = arr2[i + 1] * (i + 1) % 1000000007;

	long long X = arr1[N];
	long long Y = (arr2[N - K] * arr2[K]) % 1000000007;
	cout << X * Y % 1000000007;
}

long long solve(long long x, long long y) {
	if (y == 0)
		return 1;
	if (y % 2 == 1)
		return (solve(x, y - 1) * x) % 1000000007;

	long long tmp = solve(x, y / 2) % 1000000007;
	return tmp * tmp % 1000000007;
}

int main() {
	init();
}