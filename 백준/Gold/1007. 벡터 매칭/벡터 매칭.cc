#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include<cstring>
#include<cmath>

using namespace std;

int T, N;
double result = 1e9+7;
vector<pair<int, int>> point;
bool visited[21];

void init();
void input();
void dfs(int, int);
double get_vec();

void init() {
	memset(visited, 0, sizeof(visited));
	point.clear();
	result = 1e9 + 7;
}

void input() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		init();
		cin >> N;
		for (int j = 0; j < N; j++) {
			int x, y;
			cin >> x >> y;
			point.push_back({ x,y });
		}
		dfs(0, 0);

		printf("%.7lf\n", result);
	}

}

void dfs(int cur, int cnt) {
	if (cnt == N / 2) {
		result = min(result, get_vec());
		return;
	}
	for(int i = cur; i < N; i++){
		visited[i] = true;
		dfs(i+1, cnt+1);
		visited[i] = false;
	}
}

double get_vec() {
	pair<int, int> vec = { 0,0 };
	for (int i = 0; i < N; i++) {
		if (visited[i] == true) {
			vec.first -= point[i].first;
			vec.second -= point[i].second;
		}
		else {
			vec.first += point[i].first;
			vec.second += point[i].second;
		}
	}
	return sqrt(pow(vec.first, 2) + pow(vec.second, 2));
}

int main() {
	input();

	return 0;
}