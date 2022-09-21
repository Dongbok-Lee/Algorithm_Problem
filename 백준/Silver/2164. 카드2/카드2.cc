#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

queue<int> q;
int N;

void init();
void solve();

void init() {

	cin >> N;

	for (int i = 1; i <= N; i++) {
		q.push(i);
	}
}

void solve() {
	
	while (q.size() > 1) {
		q.pop();
		q.push(q.front());
		q.pop();
	}

	cout << q.front();
}

int main() {
	
	init();
	solve();
}
