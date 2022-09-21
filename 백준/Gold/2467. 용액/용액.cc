#include<iostream>
#include<cmath>
#define MAX 100001


using namespace std;


int N;
int p1, p2;
int _p1, _p2;
int arr[MAX] = {0,};
int result = 2000000003;
void init();
void solve();

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
}

void solve() {
	p1 = 0; p2 = N-1;

	while (p1 != p2) {
		int sum = arr[p1] + arr[p2];

		if (result >= abs(sum)) {
			result = abs(sum);
			_p1 = p1; _p2 = p2;
		}

		if (sum > 0) p2--;
		else if (sum < 0) p1++;
		else {
			cout << arr[_p1] << " " << arr[_p2];
			return;
		}
	}

	cout << arr[_p1] << " " << arr[_p2];
}

int main() {
	init();
	solve();
	return 0;
}