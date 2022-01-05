#include <iostream>
#include <algorithm>
#include <queue>
#include<cmath>
#include<cstring>
#include <map>
#include <string>

using namespace std;

void init();
void solve();

map<string,int> m;
string name[100001];
int N, M;

void init() {
	cin >> N >> M;
}

void solve() {
	string tmp;
	for (int i = 1; i <= N; i++) {
		cin >> tmp;
		name[i] = tmp;
		m.insert(make_pair(tmp, i));
	}

	for (int j = 0; j < M; j++) {
		string tmp2;
		int num;

		cin >> tmp2;

		if (isdigit(tmp2[0]) != 0) {
			num = stoi(tmp2);
			cout << name[num] << "\n";
		}
		else {
			auto result = m.find(tmp2);
			cout << result->second << "\n";
		}
	}
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	init();
	solve();
	return 0;
}//2022-01-02 solved
