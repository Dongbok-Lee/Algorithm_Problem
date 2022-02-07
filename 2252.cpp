#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include<cstring>

using namespace std;

int N, M;
int entry[32001] = {0, };
vector<int> height[32001];
queue<int> q;


void init();
void solve();

void init() {
	cin >> N >> M;
	
	for (int i = 0; i < M; i++) {
		int A, B;
		cin >> A >> B;
		height[A].push_back(B);
		entry[B]++;
	}
}

void solve() {
	for (int i = 1; i <= N; i++) {
		if (entry[i] == 0)
			q.push(i);
	}

	while (!q.empty()) {

		int cur = q.front();

		cout << cur << " ";

		for (int i = 0; i < height[cur].size(); i++) {
			int next = height[cur][i];
			entry[next]--;

			if (entry[next] == 0)
				q.push(next);
		}

		q.pop();
	}
}

int main() {
	init();
	solve();
	return 0;
}//2022-02-07 solved
