#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int N, M;
int cost[200];
int ladder[101] = {0, };


void init();
void solve();

void init() {
	memset(cost, 10000, sizeof(cost));
	cin >> N >> M;

	for (int i = 0; i < N + M; i++) {
		int x, y;
		cin >> x >> y;

		ladder[x] = y;
	}
}

void solve() {
	queue<pair<int, int>> q;

	q.push({1, 0});
		

	while (!q.empty()) {
		int cur_x = q.front().first;
		int cnt = q.front().second;
		q.pop();

		for (int i = 1; i < 7; i++) {
			if (cur_x + i == 100) {
				cout << cnt + 1;
				return;
			}

			if (ladder[cur_x + i] != 0) {
				int next = ladder[cur_x + i];
				while (ladder[next] != 0) {
					next = ladder[next];
				}
				if (cost[next] > cnt + 1) {
					cost[next] = cnt + 1;
					q.push({ next, cnt + 1 });
				}
			}

			else if (cost[cur_x + i] > cnt + 1) {
				cost[cur_x + i] = cnt + 1;
				q.push({ cur_x + i,cnt + 1 });
			}
		}
	}
}

int main() {
	init();
	solve();

	return 0;
}
