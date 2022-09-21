#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include<cstring>
#include <map>
#include <string>

using namespace std;

void init();
void solve();

vector<string> v1,v2;
int N, M;
int cnt = 0;
void init() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		string tmp;
		cin >> tmp;
		v1.push_back(tmp);
	}
}

void solve() {

	sort(v1.begin(), v1.end());

	for (int i = 0; i < M; i++) {

		string tmp;

		cin >> tmp;

		if (binary_search(v1.begin(), v1.end(), tmp)) {
			v2.push_back(tmp);
			cnt++;
		}
	}

	sort(v2.begin(), v2.end());

	cout << cnt << "\n";
	
	for (int i = 0; i < cnt; i++) {
		cout << v2[i] << "\n";
	}

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	init();
	solve();
}