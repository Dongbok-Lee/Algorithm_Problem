#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, res = 0;
int parent[100001];
vector<int> cnt_cost;
vector<pair<int, pair<int, int>>> edge;


void init();
void solve();
bool same_parent(int ,int);
int Find(int);
void Union(int ,int, int);


void init() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int cost, from, to;
		cin >> from >> to >> cost;
		edge.push_back({ cost,{from, to} });
	}
	sort(edge.begin(), edge.end());
}

void solve() {

	for (int i = 1; i <= N; i++) parent[i] = i;

	for (int i = 0; i < edge.size(); i++) {
		if (!same_parent(edge[i].second.first, edge[i].second.second))
			Union(edge[i].second.first, edge[i].second.second, edge[i].first);
	}

	for (int i = 0; i < cnt_cost.size() - 1; i++) res += cnt_cost[i];

	cout << res;
}

bool same_parent(int x, int y) {
	x = Find(x);
	y = Find(y);

	if (x == y) return true;
	else return false;
}

int Find(int x) {
	
	if (x == parent[x]) return x;
	else return parent[x] = Find(parent[x]);
}

void Union(int x, int y, int z) {
	x = Find(x);
	y = Find(y);

	if (x != y) {
		parent[y] = x;
		cnt_cost.push_back(z);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	init();
	solve();

	return 0;
}//2022-02-14 solved
