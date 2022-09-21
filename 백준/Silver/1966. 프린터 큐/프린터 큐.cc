#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;

int T, M, N;
queue<pair<int, int>> q;
vector<int> arr;
void init();
void solve();

void init() {
	cin >> T;
	for (int t = 0; t < T; t++) {
		cin >> N >> M;

		while (!q.empty())
			q.pop();

		arr.clear();

		for (int i = 0; i < N; i++) {
			int tmp;

			cin >> tmp;
			q.push({ tmp, i });
			arr.push_back(tmp);
			sort(arr.begin(), arr.end(), greater<int>());
		}
		solve();
	}
}

void solve() {
	int index = 0;
	int cnt = 0;
	while (!q.empty()) {
		for (int i = 0; i < q.size(); i++) {
			if (q.front().first == arr[index]) {
				cnt++;

				if (q.front().second == M) {
					cout << cnt << "\n";
					return;
				}

				q.pop();
				index++;
				break;
			}
			else {
				pair<int, int> tmp;
				tmp = q.front();
				q.pop();
				q.push(tmp);
			}
		}
	}
}

int main() {
	init();

	return 0;
}
