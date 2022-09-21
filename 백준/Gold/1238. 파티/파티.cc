#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#define INF 1000000000

using namespace std;

int N, M, X;
int t, a, b;
int Dist[1001];
int result[1001] = {0,};
vector<pair<int, int>> V[1001];


void init();
void solve();
void dijkstra(int);

void init() {
	cin >> N >> M >> X;

	for (int i = 0; i < M; i++) {
		cin >> t >> a >> b;
		V[t].push_back(make_pair(a, b));
	}

}

void solve() {
	fill_n(Dist, 1001, INF);

	dijkstra(X);

	for (int i = 1; i <= N; i++) {
		result[i] = Dist[i];
	}
	for (int i = 1; i <= N; i++) {
		fill_n(Dist, 1001, INF);
		dijkstra(i);
		result[i] += Dist[X];
	}
	sort(result + 1, result + N + 1);
	cout << result[N];
}

void dijkstra(int start) {
	priority_queue<pair<int, int>> pq;
	Dist[start] = 0;
	pq.push(make_pair(0, start));

	while (!pq.empty()) {
		int cost = -pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		for (int i = 0; i < V[cur].size(); i++) {
			int next = V[cur][i].first;
			int ncost = V[cur][i].second;

			if (Dist[next] > cost + ncost) {
				Dist[next] = cost + ncost;
				pq.push(make_pair(-Dist[next], next));
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();
}