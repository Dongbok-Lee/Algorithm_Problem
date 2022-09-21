#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 100005

using namespace std;

int N, M, res = 0, cnt = 0;
int parent[MAX];
vector<pair<int, pair<int, int>>> v;
vector<int> v2;


void init();
void solve();
void Union(int, int, int);
int Find(int);
bool same_parent(int ,int);

void init() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int from, to, cost;
		
		cin >> from >> to >> cost;

		v.push_back({ cost,{from,to}});
	}
	sort(v.begin(), v.end());
}

void solve() {
	for (int i = 1; i <= N; i++) parent[i] = i;

	for (int i = 0; i < v.size(); i++) {
		if (!same_parent(v[i].second.first, v[i].second.second)) {
			Union(v[i].second.first, v[i].second.second, v[i].first);
		}
	}

	for (int i = 0; i < v2.size() - 1; i++) res += v2[i];

	cout << res;
}

bool same_parent(int x, int y) {
	x = Find(x);
	y = Find(y);

	if (x == y) return true;
	else return false;
}

int Find(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = Find(parent[x]);
}

void Union(int x, int y, int z) {
	x = Find(x);
	y = Find(y);

	if (x != y) {
		parent[y] = x;
		v2.push_back(z);
	}
		
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();
	solve();

	return 0;
}