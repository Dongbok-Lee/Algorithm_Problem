#include<iostream>
#include<queue>

using namespace std;

void init();
void solve();
void dir_push(int, pair<int, int>);
bool is_inside(pair<int, int>);

int N;
int map[17][17];
int result = 0;


//1 = 가로 2 = 세로 3 = 대각선
queue<pair<int, pair<int, int>>> q;

void init() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}
}

void solve() {

	q.push({ 1,{ 0,1 } });

	while (!q.empty()) {

		int dir = q.front().first;
		pair<int, int> cur = q.front().second;
		q.pop();

		if (cur == make_pair(N - 1, N - 1))
			result++;


		if (dir == 1) {
			dir_push(1, cur); //가로
			dir_push(3, cur); //대각선
		}

		else if (dir == 2) {
			dir_push(2, cur); //세로
			dir_push(3, cur); //대각선
		}

		else if (dir == 3) {
			dir_push(1, cur); //가로
			dir_push(2, cur); //세로
			dir_push(3, cur); //대각선
		}
	}

	cout << result;
}

bool is_inside(pair<int, int>  x) {
	if (0 > x.first || x.first >= N)
		return false;

	if (0 > x.second || x.second >= N)
		return false;

	return true;
}

void dir_push(int dir, pair<int, int> cur) {
	// 가로
	if (dir == 1) 
		if (is_inside({ cur.first, cur.second + 1 }) && map[cur.first][cur.second + 1] != 1)
				q.push({ 1, {cur.first, cur.second + 1} });

	//세로
	if (dir == 2) 
		if (is_inside({ cur.first+1, cur.second}) && map[cur.first + 1][cur.second] != 1)
				q.push({ 2, {cur.first+1, cur.second} });

	//대각선
	if (dir == 3)
		if (is_inside({ cur.first + 1, cur.second + 1}))
			if (map[cur.first + 1][cur.second + 1] != 1 && map[cur.first + 1][cur.second] != 1 && map[cur.first][cur.second + 1] != 1)
				q.push({ 3, {cur.first + 1, cur.second + 1} });
}

int main() {
	init();
	solve();
	return 0;
}