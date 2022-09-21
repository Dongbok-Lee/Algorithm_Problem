#include<iostream>
#include<algorithm>
#include<cmath>
#define MAX 5001

using namespace std;

int N, num1, num2, num3;
long long arr[MAX];
long long result = 3000000001;

void init();
void solve();

void init() {
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> arr[i];

	sort(arr, arr + N);
}

void solve() {
	for (int i = 0; i < N - 2; i++) {
		for (int j = i + 1; j < N - 1; j++) {
			long long sum;
			int k;

			if (j == N - 2) {
				k = N - 1;
				sum = arr[i] + arr[j] + arr[k];
			}
			else {
				k = upper_bound(arr + j + 2, arr + N-1, -(arr[i] + arr[j])) - arr;

				sum = min(abs(arr[i] + arr[j] + arr[k]), abs(arr[i] + arr[j] + arr[k - 1]));
				if (abs(arr[i] + arr[j] + arr[k]) > abs(arr[i] + arr[j] + arr[k - 1])) k--;
			}


			if (abs(result) > sum) {
				result = sum;
				num1 = i; num2 = j; num3 = k;
			}
		}
	}
	
	cout << arr[num1] << " " << arr[num2] << " " << arr[num3];
}

int main() {
	init();
	solve();
	return 0;
}