#include<iostream>
#include<queue>
#include<cstdlib>

using namespace std;

int N;
priority_queue<int, vector<int>, greater<int>> pq1;
priority_queue<int> pq2;

void solve();

void solve() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;

		if (num > 0) {
			pq1.push(num);
		}
		else if (num < 0) {
			pq2.push(num);
		}
		else {
			if (pq1.empty() && pq2.empty()) {
				cout << 0 << "\n";
			}
			else {
				if (pq1.empty()) {
					cout << pq2.top() << "\n";
					pq2.pop();
				}
				else if (pq2.empty()) {
					cout << pq1.top() << "\n";
					pq1.pop();
				}
				else {
					if (abs(pq1.top()) == abs(pq2.top()) || abs(pq1.top()) > abs(pq2.top())) {
						cout << pq2.top() << "\n";
						pq2.pop();
					}
					else{
						cout << pq1.top() << "\n";
						pq1.pop();
					}
				}
			}
		}
	}
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
	solve();

	return 0;
}