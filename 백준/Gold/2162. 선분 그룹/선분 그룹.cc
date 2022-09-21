#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

int N, total_group = 0, max_line = 1;
int parent[5000];
bool visited[5000] = { 0, };
vector<int> v[5000];
vector<pair<int, int>> graph[5000];
queue<int> q;



void init();
void solve();
void bfs(int);
int Find(int);
int ccw(pair<int, int>, pair<int, int>, pair<int, int>);
bool check(pair<int, int>, pair<int, int>, pair<int, int>, pair<int, int>);
bool Union(int, int);

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int x1, x2, y1, y2;

		cin >> x1 >> y1 >> x2 >> y2;

		graph[i].push_back({ x1,y1 });
		graph[i].push_back({ x2,y2 });
	}
}

void solve() {
	for (int i = 0; i < N; i++) parent[i] = i;

	for (int i = 0; i < N; i++) {
		for (int j = i+1; j < N; j++) {
			if (check(graph[i][0],graph[i][1], graph[j][0], graph[j][1])) {
				Union(i, j);
			}
		}
	}

	for (int i = 0; i < N; i++) {
		if (!visited[i]) {
			total_group++;
			bfs(i);
		}
	}

	cout << total_group << "\n" << max_line;
}

bool check(pair<int, int> a, pair<int, int> b, pair<int, int> c, pair<int, int> d) {
	int ans1 = ccw(a, b, c) * ccw(a, b, d);
	int ans2 = ccw(c, d, a) * ccw(c, d, b);

	if (ans1 == 0 && ans2 == 0) {
		if (a > b) swap(a, b);
		if (c > d) swap(c, d);
		if (a <= d && b >= c) return true;
		else return false;
	}
	else {
		if (ans1 <= 0 && ans2 <= 0) return true;
		else return false;
	}
}

int ccw(pair<int, int> a, pair<int, int> b, pair<int, int> c) {
	int tmp = a.first * b.second + b.first * c.second +  c.first * a.second;
	tmp -= b.first * a.second + c.first * b.second + a.first * c.second;

	if (tmp == 0) return 0;
	else if (tmp > 0) return 1;
	else if (tmp < 0) return - 1;
}

bool Union(int a, int b) {
	a = Find(a);
	b = Find(b);

	if (a == b) return false;
	else {
		parent[a] = b;

		v[a].push_back(b);
		v[b].push_back(a);

		return true;
	}
}

int Find(int x) {
	if (parent[x] == x) return x;
	else return parent[x] = Find(parent[x]);
}

void bfs(int x) {
	
	int cnt = 1;
	q.push(x);

	while (!q.empty()) {
		int cur = q.front();
		visited[cur] = true;
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i];

			if (!visited[next]) {
				cnt++;
				q.push(next);
			}
		}
	}
	max_line = max(max_line,cnt);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solve();

	return 0;
}