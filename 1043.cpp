#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

int M, N;
int tmp, result = 0;
bool party[51][51] = { 0, };
bool visited[51] = { 0, };
queue<int> q;

void init();
void solve();

void init() {
	cin >> N >> M >> tmp;
	
	for (int i = 0; i < tmp; i++) {
		int num;
		cin >> num;
		q.push(num);
	}
	for (int i = 1; i <= M; i++) {
		int num;
		cin >> num;
		for (int j = 0; j < num; j++) {
			cin >> tmp;
			party[i][tmp] = true;
		}
	}
}

void solve() {
	while (!q.empty()) {
		for (int i = 1; i <= M; i++) {
			if (party[i][0] == false && party[i][q.front()] == true) {
				party[i][0] = true;
				visited[q.front()] = true;

				for (int k = 1; k <= N; k++) {
					if (party[i][k] == true && visited[k] == false) {
						q.push(k);
					}
				}
			}
		}
		q.pop();
	}
	
	for (int i = 1; i <= M; i++) {
		if (party[i][0] == false) {
			result++;
		}
	}
	cout << result;
}//2022-01-14 solved

int main() {
	init();
	solve();
	return 0;
}
