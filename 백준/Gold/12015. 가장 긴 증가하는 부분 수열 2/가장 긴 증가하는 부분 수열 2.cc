#include <iostream>
#include<vector>
#include<algorithm>

using namespace std;

int N ,x;
vector<int> v;

void solve();

void solve() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> x;
		if (v.empty() || v.back() < x) {
			v.push_back(x);
		}
		else {
			auto point = lower_bound(v.begin(),v.end(),x);
			*point = x;
		}
	}
	cout << v.size();
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
	solve();
	return 0;
}