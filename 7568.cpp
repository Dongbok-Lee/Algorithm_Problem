#include<iostream>
#include<stack>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

int N;
vector<pair<int, int>> v;
void init();
void solve();

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		v.push_back({ x, y });
	}
}

void solve() {
	

	for (int i = 0; i < N; i++) {
		int rate = 1;
		for (int j = 0; j < N; j++) {
			if (v[i].first < v[j].first && v[i].second < v[j].second) {
				rate++;
			}
		}
		cout << rate << " ";
	}
}

int main() {
	init();
	solve();

	return 0;
}//2022-03-19 solved
