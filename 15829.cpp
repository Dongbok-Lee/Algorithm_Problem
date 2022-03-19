#include<iostream>
#include<stack>
#include<algorithm>
#include<cmath>
#include<string>
#define M 1234567891 

using namespace std;

int N;
string s;
long long result = 0;

void solve();
long long hashing(int);

void solve() {
	cin >> N;
	cin >> s;

	for (int i = 0; i < N; i++){
		long long alpha = s[i] - 96;
		result += (alpha * hashing(i)) % M;
		result %= M;
		}
	cout << result;
}

long long hashing(int cnt) {
	long long x = 1;

	for (int i = 0; i < cnt; i++) {
		x = (x * 31) % M;
	}
	return x;
}

int main() {
	solve();
	return 0;
}//2022-03-19 solved
