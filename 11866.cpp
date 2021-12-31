#include <iostream>
#include <queue>

using namespace std;

queue<int> q;
int N, K;
int table[1001] = { 0, };

void init();
void solve();

void init() {

	cin >> N >> K;

	for (int i = 1; i <= N; i++) {
		q.push(i);
	}

	cout << "<";
}

void solve() {
	while (q.size() > 1) {
		for (int i = 1; i < K; i++) {
			int tmp = q.front();
			q.push(tmp);
			q.pop();
		}
		int out = q.front();
		q.pop();
		cout << out << ", ";
	}
	int tmp = q.front();
	cout << tmp << ">";
}

int main() {
	init();
	solve();
}//2021-12-30 solved
