#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
int T, N, M, W;
vector<vector<pair<int, int>>> V;
long long Dist[502];
int INF = 1000000000;

bool bellman(int start) {
	fill(Dist, Dist + N + 1, INF);
	Dist[start] = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 1; j <= N; j++) {
			int current = j;
			for (auto e : V[j]) {
				int next = e.first;
				int cost = e.second;
				long long nextCost = cost + Dist[current];
				if (Dist[next] > nextCost) {
					Dist[next] = nextCost;
					if (i == N - 1) return true;
				}
			}
		}
	}
	return false;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> N >> M >> W;
		V.resize(N + 1);
		int S, E, T;
		for (int i = 0; i < M; i++) {
			cin >> S >> E >> T;
			V[S].push_back(make_pair(E, T));
			V[E].push_back(make_pair(S, T));
		}
		for (int i = 0; i < W; i++) {
			cin >> S >> E >> T;
			V[S].push_back(make_pair(E, -T));
		}

		if (bellman(1))cout << "YES\n";
		else cout << "NO\n";
		V.clear();
	}
}