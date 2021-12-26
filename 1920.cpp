#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
int arr[100003];

int b_search(int num) {
	int left = 0, right = N-1;

	while (left <= right) {
		int mid = (left+right) / 2;

		if (arr[mid] == num) {
			return 1;
		}
		else if (arr[mid] >= num) {
			right = mid - 1;
		}
		else {
			left = mid+1;
		}
	}
	return 0;
}
int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++) 
		cin >> arr[i];

	sort(arr, arr + N);

	cin >> M;

	for (int j = 0; j < M; j++) {
		int tmp;
		cin >> tmp;
		cout <<b_search(tmp)<<"\n";
	}
}//2021-12-26 solved
