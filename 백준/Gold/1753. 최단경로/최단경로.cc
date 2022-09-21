#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#define INF 500000000

using namespace std;

int V, E, K;
int dist[20001];
vector<pair<int, int>> vertex[20001];

void init();
void solve();
void dijkstra(int);

void init() {
	int u, v, w;

	cin >> V >> E >> K;

	for (int i = 0; i < E; i++) {
		cin >> u >> v >> w;
		
		vertex[u].push_back(make_pair(v,w));

	}
}
void solve() {
	fill_n(dist, V + 1, INF);
	dijkstra(K);

	for (int i = 1; i <= V; i++) {
		if (dist[i] == INF) {
			cout << "INF\n";
		}
		else {
			cout << dist[i] << '\n';
		}
	}
}

void dijkstra(int start) {

	priority_queue<pair<int, int>> pq;

	pq.push(make_pair(0,start));

	dist[start] = 0;

	while (pq.empty() == 0) {
		
		int cur_w = -pq.top().first;
		int cur = pq.top().second;

		pq.pop();

		for (int i = 0; i < vertex[cur].size(); i++) {

			int next = vertex[cur][i].first;
			int next_w = vertex[cur][i].second;

			if (dist[next] > cur_w + next_w) {
				
				dist[next] = cur_w + next_w;

				pq.push(make_pair(-dist[next], next));
			}
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(); cout.tie();

	init();
	solve();
}