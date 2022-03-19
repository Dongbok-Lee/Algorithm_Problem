#include<iostream>
#include<stack>
#include<algorithm>
#include<cmath>
#include<string>

using namespace std;

int N, M, B;
int Min = 1e9;
int Max = -1;
int board[502][502];

void solve();

void solve() {
	cin >> N >> M >> B;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}

	for (int height = 0; height <= 256; height++) {
		int item = 0;
		int remove = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int curheight = board[i][j] - height;
				if (curheight < 0) item -= curheight;
				else remove += curheight;
			}
		}

		if (remove + B >= item) {
			int ttime = 2 * remove + item;
			if (Min >= ttime) {
				Min = ttime;
				Max = height;
			}
		}
	}
	cout << Min << " " << Max;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	solve();
	return 0;
}//2022-03-19 solved
