#include <iostream>
#include <algorithm>
#include <vector>
#include <stdlib.h>

using namespace std;

int N;
double result = 0;
vector<pair<double, double>> v;

void ccw(int, int);
void init();
void solve();

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		v.push_back({ x,y });
	}
}

void solve() {
	for (int i = 1; i < N-1; i++) {
		ccw(i, i + 1);
	}
	cout << fixed;
	cout.precision(1);
	cout << abs(result);
}

void ccw(int x, int y) {
	double tmp = v[0].first * v[x].second + v[x].first * v[y].second + v[y].first * v[0].second;
	tmp -= v[x].first * v[0].second + v[y].first * v[x].second + v[0].first * v[y].second;

	result += tmp/2.0;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	return 0;
}