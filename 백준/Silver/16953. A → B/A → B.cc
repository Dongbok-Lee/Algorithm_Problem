#include<iostream>
#include<queue>

using namespace std;

void init();
void solve();

long long A, B;
queue<pair<long long, long long>> q;

void init() {
	cin >> A >> B;
}

void solve() {
	q.push({ A,1});

	while (!q.empty()) {

		pair<long long, long long> cur = q.front();
		q.pop();

		if (cur.first * 2 < B) 
			q.push({ cur.first * 2, cur.second + 1 });
		

		if (cur.first * 10 + 1 < B) 
			q.push({ cur.first * 10 + 1, cur.second + 1 });
		

		if (cur.first * 2 == B || cur.first * 10 + 1 == B) {
			cout << cur.second + 1;
			return;
		}
		
	}
	cout << -1;
	return;
}

int main() {
	init();
	solve();
	return 0;
}