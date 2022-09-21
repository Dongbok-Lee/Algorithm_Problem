#include <iostream>
#include<algorithm>
#include<queue>

using namespace std;

bool visited[100001];
queue<pair<int, int>> q;
int N, K, result = 1000000000;

void solve();

void solve() {
	cin >> N >> K;
	if (K == 0) {
		cout << N;
		return;
	}
	if (N == 0) {
		if (K == 0) {
			cout << 0;
			return;
		}
		q.push({ 1,1 });
	}
	else
		q.push({ N,0 });

	while (!q.empty()) {
		int cur = q.front().first;
		int cnt = q.front().second;
		q.pop();
		if (cur == K)
			result = min(result, cnt);
		for (int i = cur * 2; i <= 100000; i *= 2) {
			if (!visited[i]) {
				q.push({ i,cnt });
				visited[i] = true;
			}
		}

		if (cur + 1 < 100001 && !visited[cur + 1]) {
			q.push({ cur + 1,cnt + 1 });
			visited[cur+1] = true;
		}
			
		if (cur > 1 && !visited[cur - 1]) {
			q.push({ cur - 1,cnt + 1 });
			visited[cur-1] = true;
		}
			
	}
	cout << result;
}

int main() {
	solve();
}