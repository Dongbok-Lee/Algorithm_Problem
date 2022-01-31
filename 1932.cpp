#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int N,tmp;
int Max = 0;
vector<pair<int, int>> v[501];

void init();
void solve();

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			cin >> tmp;
			v[i].push_back({tmp,0});
		}
	}
}

void solve() {
	v[0][0].second = v[0][0].first;
	Max = v[0][0].second;

	for (int i = 0; i < N-1; i++) {
		for (int j = 0; j <= i; j++) {

			int cur_total= v[i][j].second;
			int next_cost = v[i+1][j].first;
			int next_cost2 = v[i + 1][j + 1].first;
			int next_total = v[i + 1][j].second;
			int next_total2 = v[i + 1][j + 1].second;

			if (next_total < next_cost + cur_total)
				v[i + 1][j].second = next_cost + cur_total;

			if (next_total2 < next_cost2 + cur_total)
				v[i + 1][j + 1].second = next_cost2 + cur_total;

			if (i == N - 2) {
				if (Max < v[i + 1][j].second || Max < v[i + 1][j+1].second) {
					Max = max(v[i + 1][j].second, v[i + 1][j+1].second);
				}
			}
		}
	}
	cout << Max;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	init();
	solve();

	return 0;
}//2022-01-30 solved
