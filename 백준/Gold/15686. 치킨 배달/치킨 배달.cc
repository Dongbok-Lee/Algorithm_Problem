#include<iostream>
#include<algorithm>
#include<queue>

using namespace std;

void init();
void solve(int, int);
int get_distance(pair<int, int>, pair<int, int>);
int get_minimum_distance();

int N, M;
int map[51][51];
int answer = 987654321;
vector<pair<int, int>> home;
vector<pair<int, int>> chicken;
vector<pair<int, int>> selected_chicken;

void init() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				home.push_back({ i, j });
			}
			else if (map[i][j] == 2) {
				chicken.push_back({ i, j });
			}
		}
	}

	for (int i = 0; i < M; i++) {
		selected_chicken.push_back({0,0});
	}
}
void solve(int index, int len) {
	if (len == M) {
		answer = min(answer, get_minimum_distance());
		return;
	}
	for (int i = index; i < chicken.size()-M+len+1; i++) {
		selected_chicken[len] = chicken[i];
		solve(i + 1, len + 1);
	}

}



int get_minimum_distance() {
	int distance = 0;
	for (int i = 0; i < home.size(); i++) {
		int tmp = 987654321;
		for (int j = 0; j < selected_chicken.size(); j++) {
			tmp = min(tmp, get_distance(home[i], selected_chicken[j]));
		}
		distance += tmp;
	}
	return distance;
}

int get_distance(pair<int, int> x, pair<int, int> y) {
	return abs(x.first - y.first) + abs(x.second - y.second);
}

int main() {
	init();
	solve(0, 0);
	cout << answer;
	return 0;
}