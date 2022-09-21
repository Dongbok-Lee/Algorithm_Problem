#include<iostream>
#include<algorithm>

using namespace std;

int N;
int graph[101][101];

void init();
void solve();

void init() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> graph[i][j];
		}
	}
}

void solve() {
	for (int i = 1; i <= N; i++) 
		for (int j = 1; j <= N; j++) 
			for (int k = 1; k <= N; k++) 
				if (graph[j][i] && graph[i][k])
					graph[j][k] = 1;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cout << graph[i][j] << " ";
		}
		cout << "\n";
	}
}


int main() {
	init();
	solve();
	return 0;
}