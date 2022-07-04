#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;

#define INF 987654321

int answer;
int dist[101];
int N, M, R;
int local[101];
vector<pair<int, int>> V[101];

void init();
void solve(int);

void init() {
	cin >> N >> M >> R;
	for (int i = 1; i <= N; i++)
		cin >> local[i];

	for (int i = 0; i < R; i++) {
		int x, y, d;
		cin >> x >> y >> d;
		V[x].push_back({y,d});
		V[y].push_back({ x,d });
	}

	for (int i = 1; i <= N; i++)
		solve(i);
}

void solve(int start) {
	int cnt = 0;
	queue<int> q;

	for (int i = 1; i <= N; i++)
		dist[i] = INF;

	dist[start] = 0;

	q.push(start);

	while (!q.empty()) {
		int cur = q.front();
		int cost = dist[cur];
		q.pop();

		for (int i = 0; i < V[cur].size(); i++) {
			int next = V[cur][i].first;
			int next_cost = V[cur][i].second;

			if (dist[next] > cost + next_cost) {
				dist[next] = cost + next_cost;
				q.push(next);
			}
		}
	}

	for (int i = 1; i <= N; i++)
		if (dist[i] <= M)
			cnt += local[i];

	answer = max(answer, cnt);
}

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	init();
	cout << answer;
	return 0;
}