#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int N, M;
int input_degree[32001] = {0,};
vector<int> vertex[32001];
priority_queue<int,vector<int>, greater<int>> pq;

void init();
void solve();

void init() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int from, to;
		cin >> from >> to;
		vertex[from].push_back(to);
		input_degree[to]++;
	}
}

void solve() {
	for (int i = 1; i <= N; i++)
		if (input_degree[i] == 0) pq.push(i);

	while (!pq.empty()) {

		int cur = pq.top();
		pq.pop();
		cout << cur << " ";

		for (int i = 0; i < vertex[cur].size(); i++) {
			int next = vertex[cur][i];

			if (--input_degree[next] == 0) {
				pq.push(next);
			}
		}
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();

	return 0;
}//2022-02-16 solved
