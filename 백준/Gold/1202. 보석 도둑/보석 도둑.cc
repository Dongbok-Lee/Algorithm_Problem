#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<set>
#define MAX 300000+1
using namespace std;

int N, K;
priority_queue<pair<int, int>> pq;
multiset<int> bag;
long long result = 0;


void init();
void solve();

void init() {
	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		int M, V;
		cin >> M >> V;
		pq.push({ V,M });
	}

	for (int i = 0; i < K; i++) {
		int C;
		cin >> C;
		bag.insert(C);
	}
}

void solve() {
	while (!pq.empty()) {
		
		int cost = pq.top().first;
		int weight = pq.top().second;

		pq.pop();

		auto it = bag.lower_bound(weight);

		if (it != bag.end()) {
			bag.erase(it);
			result += cost;
		}
		

	}
	cout << result;
}

int main() {
	
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();
	solve();

	return 0;
}