#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

int N, tmp;
vector<int> v;

void init();
void solve();

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		v.push_back(tmp);
	}
}

void solve() {
	vector<int> v2(v);
	sort(v2.begin(), v2.end());

	v2.erase(unique(v2.begin(), v2.end()), v2.end());
	for (int i = 0; i < N; i++) {
		auto it = lower_bound(v2.begin(), v2.end(), v[i]);

		cout << it - v2.begin() << " ";
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	init();
	solve();
}