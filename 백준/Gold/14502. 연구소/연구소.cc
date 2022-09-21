#include<iostream>
#include<vector>
#include<queue>

using namespace std;

void init();
void solve();
void comb_recursion(int, int);
bool is_inside(int, int);
int chk_safe_area(int [8][8]);

int N, M;
int map[8][8];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0 , -1 };
int max_safe_area = 0;

void init() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}
}

void solve() {
	comb_recursion(3, 0);
	cout << max_safe_area;
}

void bfs() {

	int tmp[8][8];

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			tmp[i][j] = map[i][j];
		}
	}

	queue <pair<int, int>> q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (tmp[i][j] == 2) {
				q.push({ i,j });
			}
		}
	}

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;

		q.pop();

		for (int i = 0; i < 4; i++) {
			if (is_inside(x+dx[i],y+dy[i]) && tmp[x + dx[i]][y + dy[i]] == 0) {
				tmp[x + dx[i]][y + dy[i]] = 2;
				q.push({ x + dx[i], y + dy[i] });
			}
		}
	}



	if (max_safe_area < chk_safe_area(tmp)) {
		max_safe_area = chk_safe_area(tmp);
	}

	return;
}

void comb_recursion(int n, int a) {
	if (n == 0) {
		bfs();

		return;
	}
	
	for (int i = a; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] == 0) {
				map[i][j] = 1;
				comb_recursion(n - 1, i);
				map[i][j] = 0;
			}
		}
	}

}

bool is_inside(int a, int b) {
	if (a < 0 || a >= N)
		return false;
	if (b < 0 || b >= M)
		return false;

	return true;
}

int chk_safe_area(int map[8][8]) {
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if(map[i][j] == 0)
				cnt++;
		}
	}

	return cnt;
}

int main() {
	init();
	solve();
	return 0;
}