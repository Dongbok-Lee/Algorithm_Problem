#include <iostream>
#include <algorithm>
#include <queue>
#include <functional>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;
int N;

void init();
void solve();

void init() {
	cin >> N;
}

void solve() {
	for (int i = 0; i < N; i++) {
		int num;

		cin >> num;

		if (num == 0) {
			if (pq.size()) {
				cout << pq.top()<<"\n";
				pq.pop();
			}
			else {
				cout << 0 << "\n";
			}
		}
		else {
			pq.push(num);
		}
	}
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
	init();
	solve();
}