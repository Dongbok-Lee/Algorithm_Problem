#include<iostream>
#include<cstring>
#define INF 987654321

using namespace std;

int n, m;
int floyd[101][101];

void init();
void solve();

void init() {

	cin >> n >> m;

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			if (i != j)
				floyd[i][j] = INF;


	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		if(floyd[from][to] > cost)
			floyd[from][to] = cost;
	}
}

void solve() {
	for (int i = 1; i <= n; i++) 
		for (int j = 1; j <= n; j++) 
			for (int k = 1; k <= n; k++) 
				if (floyd[j][i] != INF && floyd[i][k] != INF) 
					floyd[j][k] = min(floyd[j][k], floyd[j][i] + floyd[i][k]);

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (floyd[i][j] == INF)
				cout << 0 << " ";
			else
				cout << floyd[i][j] << " ";
		}
		cout << "\n";
	}
}

int main() {
    ios::sync_with_stdio(false);
	cout.tie(0); cin.tie(0);
	init();
	solve();
	return 0;
}

