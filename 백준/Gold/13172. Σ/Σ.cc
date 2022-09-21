#include <iostream>
#define MOD 1000000007

using namespace std;


long long M, a, b;
long long power(long long , long long);
void solve();

long long power(long long n, long long m) {
    long long ret = 1;
    while (m) {
        if (m & 1) ret = ret * n % MOD;
        m = m / 2;
        n = n * n % MOD;
    }
    return ret;
}

void solve() {
    cin >> M;
    long long answer = 0;

    while (M--) {
        cin >> a >> b;
        answer += (b * (power(a, MOD - 2))) % MOD;
    }

    cout << answer % MOD;

}

int main() {
	solve(); 
	return 0;
}