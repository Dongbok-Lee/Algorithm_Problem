#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
using namespace std;

priority_queue<long long, vector<long long>, greater<long long>> pq;
long long arr[100];
map<long long, bool> visited;
int K, N;

void init();
void solve();

void init() {
	cin >> K >> N;

	for (int i = 0; i < K; i++)
		cin >> arr[i];
}

void solve() {
	pq.push(1);
	long long maxValue = 0;

	while (N) {
		long long cur = pq.top();
		pq.pop();

		for (int i = 0; i < K; i++) {
			long long next = cur * arr[i];
			if (pq.size() > N && next > maxValue)
				continue;

			if (!visited.count(next)) {
				maxValue = max(maxValue, next);
				visited[next] = true;
				pq.push(next);
			}
		}
		N--;
	}
}

int main() {
	init();
	solve();
	cout << pq.top();
	return 0;
}