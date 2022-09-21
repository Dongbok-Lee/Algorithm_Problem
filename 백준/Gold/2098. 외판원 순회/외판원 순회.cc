#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, fullbit;
int map[16][16];
int cost[16][1 << 16];

void init();
void solve();
int dfs(int ,int);

void init() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}

	fullbit = (1 << n) - 1;
}

void solve() {
	memset(cost, -1, sizeof(cost));

	cout << dfs(0, 1);

	return;
}

int dfs(int cur_node ,int cur_bit) {
	if (cur_bit == fullbit) {
		if(map[cur_node][0] == 0) return 1000000000;
		else return map[cur_node][0];
	}
	

	if (cost[cur_node][cur_bit] != -1) return cost[cur_node][cur_bit];
	cost[cur_node][cur_bit] = 1000000000;

	for (int i = 0; i < n; i++) {

		if (map[cur_node][i] == 0 || (cur_bit & 1 << i) == 1 << i) continue;

		cost[cur_node][cur_bit] = min(cost[cur_node][cur_bit], map[cur_node][i] + dfs(i, cur_bit | 1 << i));
	}
	return cost[cur_node][cur_bit];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();

	return 0;
}