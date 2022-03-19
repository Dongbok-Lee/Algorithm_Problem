#include<iostream>
#include<queue>
#include<algorithm>
#include<cmath>
using namespace std;

int N;
double sum = 0;
int num[8002] = {0, };

void init();
void solve();

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		num[n + 4000]++;
		sum += n;
	}
}

void solve() {
	cout << floor(sum / N + 0.5) << "\n";
	//산술평균
	int center = 0;	//중앙값
	int min = 0; //최빈값
	int Min = 8001; int Max = -1; // 범위
	for (int i = 0; i < 8001; i++) {
		if (num[i] != 0) {
			center += num[i];
			if (center > N / 2) {
				cout << i - 4000 << "\n";
				break;
			}
		}
	}

	for (int i = 0; i < 8001; i++) {
		if (num[i] != 0) {
			if (num[i] > min) {
				min = num[i];
			}

			if (Min > i)
				Min = i;
			if (Max < i)
				Max = i;
		}
	}

	int cnt = 2;
	int result = 0;
	for (int i = 0; i < 8001; i++) {
		if (num[i] == min) {
			result = i - 4000;
			cnt--;
		}
		if (cnt == 0) {
			result = i - 4000;
			break;
		}
	}
	cout << result << "\n";
	cout << Max - Min;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();
	solve();

	return 0;
}//2022-03-19 solved
