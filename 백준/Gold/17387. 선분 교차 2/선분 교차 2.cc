#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

pair<pair<long long, long long>, pair<long long, long long>> A;
pair<pair<long long, long long>, pair<long long, long long>> B;

void init();
void solve();
int ccw(pair<long long, long long>, pair<long long, long long>, pair<long long, long long>);

void init() {
	cin >> A.first.first >> A.first.second >> A.second.first >> A.second.second;
	cin >> B.first.first >> B.first.second >> B.second.first >> B.second.second;
}

void solve() {
	int a = ccw(A.first, A.second, B.first);
	int b = ccw(A.first, A.second, B.second);
	int c = ccw(B.first, B.second, A.first);
	int d = ccw(B.first, B.second, A.second);

	if (a * b == 0 && c * d == 0) {
		if (A.first > A.second)swap(A.first, A.second);
		if (B.first > B.second)swap(B.first, B.second);
		if (A.first <= B.second && B.first <= A.second)
			cout << 1;
		else
			cout << 0;

		return;
	}

	if (a * b <= 0 && c * d <= 0)
		cout << 1;
	else
		cout << 0;
}

int ccw(pair<long long, long long> x, pair<long long, long long> y, pair<long long,long long> z) {
	long long tmp = x.first * y.second + y.first* z.second + z.first * x.second;

	tmp = tmp - x.second * y.first - y.second * z.first - z.second * x.first;

	if (tmp > 0) return 1; //시계
	else if (tmp == 0) return 0; // 수평
	else if (tmp < 0) return -1; // 반시계
}

int main() {
	init();
	solve();
	return 0;
}