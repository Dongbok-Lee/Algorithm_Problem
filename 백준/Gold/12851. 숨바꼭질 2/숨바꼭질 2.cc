#include<iostream>
#include<vector>
#include<queue>

using namespace std;

void init();
void solve();

int N, K;
int min_cost = 0;
int result_cnt = 0;
bool visited[100010];

queue<pair<int, int>> q;


void init() {
	cin >> N >> K;
}

void solve() {

	q.push({ N,0 });

	while (!q.empty()) {
		int cur_loc = q.front().first;
		int cur_cost = q.front().second;
		q.pop();
		visited[cur_loc] = true;

		if (min_cost && min_cost == cur_cost && cur_loc == K)
			result_cnt++;

		if (!min_cost && cur_loc == K) {
			min_cost = cur_cost;
			result_cnt++;
		}


		if( 0 <= cur_loc-1 && !visited[cur_loc-1])
			q.push({ cur_loc - 1, cur_cost + 1 });
		if( 100001 > cur_loc+1 && !visited[cur_loc+1])
			q.push({ cur_loc + 1, cur_cost + 1 });
		if(100001 > cur_loc * 2 && !visited[cur_loc*2])
			q.push({ cur_loc * 2, cur_cost + 1 });
	}
	

	cout << min_cost << "\n" << result_cnt;
}

int main() {
	init();
	solve();

	return 0;
}