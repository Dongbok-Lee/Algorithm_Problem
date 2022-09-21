#include <iostream>
#include <vector>
#include <queue>
#define INF 1000000000 

using namespace std;

int N, M;
int from, to, cost;
int start, finish;
int Dist[1001];
vector<pair<int, int>> V[1001];
priority_queue<pair<int, int>> pq;

void init();
void solve();
void dijkstra(int);

void init() {
	cin >> N >> M;

	for (int i = 1; i <= M; i++) {
		cin >> from >> to >> cost;
		V[from].push_back({ to, cost });
	}
	for (int i = 1; i <= N; i++)
		Dist[i] = INF;
}

void solve() {
	cin >> start >> finish;
	dijkstra(start);
}

void dijkstra(int start) {
	Dist[start] = 0;
	pq.push({ 0, start });

	while (!pq.empty()) {
		int cur_cost = -pq.top().first;
		int cur = pq.top().second;

		pq.pop();

		if (Dist[cur] < cur_cost)
			continue;
		
		for (int i = 0; i < V[cur].size(); i++) {
			int next_cost = V[cur][i].second;
			int next = V[cur][i].first;

			if (Dist[next] > cur_cost + next_cost) {
				Dist[next] = cur_cost + next_cost;
				pq.push({ -Dist[next], next });
			}
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
	cout << Dist[finish];
	return 0;
}