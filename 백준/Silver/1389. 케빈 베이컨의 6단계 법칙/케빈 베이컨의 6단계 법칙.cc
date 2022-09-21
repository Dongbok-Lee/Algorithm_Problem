#include<iostream>
#include<vector>
#include<queue>

using namespace std;

vector<int> v[101];
int N, M;
int cost[101] = { 0, };
int result = 1e9;
int index = 0;

void init();
void solve();

void init() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		v[x].push_back(y);
		v[y].push_back(x);
	}
}

void solve() {
	for (int i = 1; i <=N; i++) {
		queue<pair<int, int>> q;
		bool visited[101] = { 0, };
		q.push({ i, 0 });
		visited[i] = true;
		while (!q.empty()) {
			int cur = q.front().first;
			int cur_cnt = q.front().second;
			
			q.pop();

			for (int j = 0; j < v[cur].size(); j++) {
				if (visited[v[cur][j]] == 0) {
					visited[v[cur][j]] = true;
					q.push({ v[cur][j], cur_cnt + 1 });
					cost[i] += cur_cnt + 1;
				}
			}
		}
	}

	for (int i = 1; i <= N; i++) {
		if (result > cost[i]) {
			result = cost[i];
			index = i;
		}
	}
	cout << index;
}

int main() {
	init();
	solve();
	return 0;
}