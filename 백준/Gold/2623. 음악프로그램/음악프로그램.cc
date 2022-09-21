#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, M;
bool visited[1001] = {0, };
queue<int> q;
vector<int> v[1001];
vector<int> parent[1001];
vector<int> result;


void init();
void solve();
bool chk_available();

void init() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int num, tmp;

		cin >> num;
		cin >> tmp;

		for (int j = 0; j < num-1; j++) {
			int x;
			cin >> x;
			parent[x].push_back(tmp);
			v[tmp].push_back(x);
			tmp = x;
		}
	}
}

void solve() {
	for (int i = 1; i <= N; i++)
		if (parent[i].size() == 0) q.push(i);

	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		
		result.push_back(cur);
		visited[cur] = true;


		for (int i = 0; i < v[cur].size(); i++) {
			int v_cur = v[cur][i];
			for (int j = 0; j < parent[v_cur].size(); j++) {
				if (parent[v_cur][j] == cur) {
					parent[v_cur].erase(parent[v_cur].begin() + j);
					if (parent[v_cur].size() == 0) q.push(v_cur);
					break;
				}
			}
		}
	}

	if (chk_available()) {
		for (int i = 0; i < N; i++) {
			cout << result[i] << "\n";
		}
	}
}

bool chk_available() {
	if (result.size() != N) {
		cout << "0";
		return false;
	}
	return true;
}

int main() {
	init();
	solve();
	return 0;
}