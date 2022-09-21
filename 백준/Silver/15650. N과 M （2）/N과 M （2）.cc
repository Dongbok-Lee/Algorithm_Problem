#include <iostream>
#include<algorithm>
#include<queue>

using namespace std;

int N, M;
bool visited[9];
void solve();
void dfs(int, int);

void solve() {
	cin >> N >> M;	
		dfs(1, 0);
}

void dfs(int index, int cnt) {
	if (cnt == M) {
		for (int i = 1; i <= N; i++)
			if (visited[i])
				cout << i << " ";
		cout << "\n";
		return;
	}

	
	for (int i = index; i <= N; i++) {
		visited[i] = true;
		dfs(i+1, cnt + 1);
		visited[i] = false;
	}
}

int main() {
	solve();
}