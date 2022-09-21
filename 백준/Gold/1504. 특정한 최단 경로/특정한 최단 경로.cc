#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#define INF 500000000

using namespace std;
int a, b, c;
int v1, v2;
int N, E;
int result;
int dist[801];
vector<pair<int, int>> V[801];

void init();
void solve();
void dijkstra(int);

void init() {
	cin >> N >> E;

	for (int i = 0; i < E; i++) {
		cin >> a >> b >> c;
		V[a].push_back(make_pair(b, c));
		V[b].push_back(make_pair(a, c));
	}
	cin >> v1 >> v2;
}

void solve() {
	fill_n(dist, 801, INF);
	dijkstra(v1);
	result = dist[v2];

	int tmp1 = dist[1];
	int tmp2 = dist[N];

	fill_n(dist, 801, INF);
	dijkstra(v2);

	result = min(tmp1 + result + dist[N], tmp2 + result + dist[1]);
	if (result >= INF) {
		cout << -1;
	}
	else {
		cout << result;
	}
}

void dijkstra(int end) {
	priority_queue<pair<int, int>> pq;
	dist[end] = 0;
	pq.push(make_pair(0, end));

	while (!pq.empty()) {
		int cost = -pq.top().first;
		int cur = pq.top().second;

		pq.pop();

		for (int i = 0; i < V[cur].size(); i++) {
			int next = V[cur][i].first;
			int n_cost = V[cur][i].second;

			if (dist[next] > cost + n_cost) {
				dist[next] = cost + n_cost;

				pq.push(make_pair(-dist[next],next));
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();
	solve();

	return 0;
}