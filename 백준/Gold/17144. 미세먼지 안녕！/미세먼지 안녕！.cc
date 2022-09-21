#include<iostream>
#include<queue>

using namespace std;

void init();
void solve();
void diffusion();
void cycle();
void get_total();

bool is_inside(int, int);

int R, C, T; //세로 가로 시간
int result = 0;
int room[51][51];
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };
pair<int, int> anticlockwise = { 0,0 };
pair<int, int> clockwise;

void init() {
	cin >> R >> C >> T;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> room[i][j];

			//청정기 위치
			if (room[i][j] == -1) {
				if (anticlockwise == make_pair(0, 0)) {
					anticlockwise = { i,j };
				}
				else 
					clockwise = { i, j };
			}
		}
	}
}

void solve() {
	for (int i = 0; i < T; i++) {
		diffusion();
		cycle();
	}
	get_total();
	cout << result;
}


void diffusion() {
	int add[51][51] = {0, };
	int minus[51][51] = { 0, };
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			//미세먼지가 있는 공간일 경우
			if (room[i][j] > 0) {
				//모든방향 검사
				for (int k = 0; k < 4; k++) {
					if (is_inside(i + dx[k], j + dy[k]) && room[i+dx[k]][j+dy[k]] != -1) {
						add[i + dx[k]][j + dy[k]] += room[i][j] / 5;
						minus[i][j] += room[i][j] / 5;
					}
				}
			}
		}
	}
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			room[i][j] += add[i][j];
			room[i][j] -= minus[i][j];
		}
	}
}

void cycle() {
	//반시계방향
	for (int i = anticlockwise.first-2; i >= 0; i--) 
		room[i + 1][0] = room[i][0];
	for (int i = 1; i <= C-1; i++) 
		room[0][i-1] = room[0][i];
	for (int i = 1; i <= anticlockwise.first; i++) 
		room[i-1][C-1] = room[i][C-1];
	for (int i = C-1; i > 0; i--)
		room[anticlockwise.first][i + 1] = room[anticlockwise.first][i];

	room[anticlockwise.first][anticlockwise.second + 1] = 0;

	//시계방향
	for (int i = clockwise.first + 2; i < R; i++)
		room[i - 1][clockwise.second] = room[i][clockwise.second];
	for (int i = 1; i < C; i++)
		room[R - 1][i - 1] = room[R - 1][i];
	for (int i = R - 2; i >= clockwise.first; i--)
		room[i + 1][C - 1] = room[i][C - 1];
	for (int i = C - 2; i >= 1; i--)
		room[clockwise.first][i + 1] = room[clockwise.first][i];

	room[clockwise.first][clockwise.second + 1] = 0;
}

bool is_inside(int x, int y) {
	if (x >= R || x < 0)
		return false;
	if (y >= C || y < 0)
		return false;

	return true;
}

void get_total() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (room[i][j] >= 0)
				result += room[i][j];
		}
	}
}

int main() {
	init();
	solve();
	return 0;
}