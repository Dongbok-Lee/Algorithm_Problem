#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

int N;
priority_queue<int, vector<int>> q;

void init();
void solve();

void init() {
	cin >> N;
}

void solve() {
	int tmp;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		if (!tmp && !q.empty()) {
			cout << q.top() << '\n';
			q.pop();
		}
		else if (!tmp && q.empty()) {
			cout << 0 << '\n';
		}
		else if(tmp){
			q.push(tmp);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	init();
	solve();
}