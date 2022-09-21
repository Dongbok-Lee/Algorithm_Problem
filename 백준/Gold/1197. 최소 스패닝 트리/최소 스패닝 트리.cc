#include<iostream>
#include<vector>
#include<algorithm>

#define MAX 10000 + 1

using namespace std;

int vertex, E, answer = 0;
int parent[MAX];
vector<pair<int, pair<int, int>>> v;

void input() {
	cin >> vertex >> E;

	for (int i = 0; i < E; i++) {
		int from, to, cost;

		cin >> from >> to >>cost;

		v.push_back({ cost,{from, to} });
	}

	sort(v.begin(), v.end());
}

int Find(int x) {
	if (parent[x] == x) 
		return x;

	else 
		return parent[x] = Find(parent[x]);
}

void Union(int x, int y) {
	x = Find(x);
	y = Find(y);

	if (x != y) 
		parent[y] = x;	
}

bool sameParent(int x,int y) {
	x = Find(x);
	y = Find(y);

	return (x == y);
}

void solution() {
	for (int i = 1; i <= vertex; i++) 
		parent[i] = i;


	for (int i = 0; i < E; i++) {
		if (!sameParent(v[i].second.first, v[i].second.second)) {
			Union(v[i].second.first, v[i].second.second);
			answer += v[i].first;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	input();
	solution();

	cout << answer;
}