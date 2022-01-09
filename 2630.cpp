#include <iostream>
#include <algorithm>
#include <queue>
#include <functional>

using namespace std;

int paper[129][129];
int N, bcnt = 0, wcnt = 0;

void init();
void solve(int, int , int);
bool chk_color(int, int, int, int);

void init() {
	cin >> N;
	
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> paper[i][j];
		}
	}
}

void solve(int n, int x, int y) {

	if (!chk_color(x, x+(n / 2)-1, y, y + (n / 2)-1)) {
		solve(n / 2, x, y);
	}
		
	if (!chk_color(x, x+(n / 2)-1, y+(n / 2), y+n-1)) {
		solve(n / 2, x, y + (n / 2));
	}
		
	if (!chk_color(x + (n / 2), x + n-1, y, y + (n / 2)-1)) {
		solve(n / 2, x + (n / 2), y);
	}

	if (!chk_color(x + (n / 2),x + n-1,y + (n / 2),y + n-1)) {
		solve(n / 2, x + (n / 2), y + (n / 2));
	}
}

bool chk_color(int x1, int x2, int y1, int y2) {
	for (int i = x1; i <= x2; i++) {
		for (int j = y1; j <= y2; j++) {
			if (paper[i][j] != paper[x1][y1])
				return false;
		}
	}

	if (paper[x1][y1] == 1) {
		bcnt++;
	}
	else {
		wcnt++;
	}

	return true;
}

int main() {
	init();
	if(!chk_color(1,N,1,N))
		solve(N, 1, 1);
	cout << wcnt << "\n" << bcnt;
	return 0;
}//2022-01-08 solved
