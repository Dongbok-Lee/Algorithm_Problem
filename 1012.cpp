#include <iostream>
#include <algorithm>
#include <queue>
#include<cstring>

using namespace std;

int tcase, row, column;
int plant, trow, tcolumn;
int cnt = 0;
int field[51][51] = { 0, };
int visited[51][51] = { 0, };
int rrow[] = { -1, 1, 0, 0 };
int ccol[] = { 0, 0, -1, 1 };

bool isInside(int row,int column, int x, int y) {
	return (0 <=  x < row && 0 <= y < column);
}

void bfs(int field[][51], int visited[][51], int row2, int col2) {
	queue<pair<int, int>> q;

	q.push(make_pair(row2, col2));

	while (!q.empty()) {

		pair<int,int> tmp = q.front();
		q.pop();

		for (int m = 0; m < 4; m++) {
			int tmprow = tmp.first +rrow[m];
			int tmpcol = tmp.second + ccol[m];
			if (isInside(row, column, tmprow, tmpcol)) {
				if (visited[tmprow][tmpcol] == 0 && field[tmprow][tmpcol] == 1) {
					q.push(make_pair(tmprow, tmpcol));
					visited[tmprow][tmpcol] = 1;
				}
			}
		}
	}


}

int main() {
	cin >> tcase;

	for (int i = 0; i < tcase; i++) {
		memset(field, 0, sizeof(field));
		memset(visited, 0, sizeof(visited));
		cin >> row >> column >> plant;

		for (int j = 0; j < plant; j++) {
			cin >> trow >> tcolumn;
			field[trow][tcolumn] = 1;
		}

		for (int k = 0; k < row; k++) {
			for (int l = 0; l < column; l++) {
				if (visited[k][l] == 0 && field[k][l] == 1) {
					bfs(field,visited,k,l);
					cnt++;
				}
			}
		}

		cout << cnt << "\n";
		cnt = 0;
	}
	
	return 0;
}2022-01-01 solved
