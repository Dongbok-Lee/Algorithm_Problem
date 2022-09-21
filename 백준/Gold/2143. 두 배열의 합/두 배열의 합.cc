#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

long long T, result = 0;
int N, M;
int arr1[1000];
int arr2[1000];
vector<long long> v1;
vector<long long> v2;

void init();
void solve();

void init() {
	cin >> T;

	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> arr1[i];

	cin >> M;
	for (int i = 0; i < M; i++)
		cin >> arr2[i];
}

void solve() {

	for (int i = 0; i < N; i++) {
		long long Sum = arr1[i];
		v1.push_back(Sum);

		for (int j = i+1; j < N; j++) {
			Sum += arr1[j];
			v1.push_back(Sum);
		}
	}

	for (int i = 0; i < M; i++) {
		long long Sum = arr2[i];
		v2.push_back(Sum);

		for (int j = i+1; j < M; j++) {
			Sum += arr2[j];
			v2.push_back(Sum);
		}
	}

	sort(v1.begin(), v1.end());
	sort(v2.begin(), v2.end());

	for (int i = 0; i < v1.size(); i++) {
		long long tmp;
		tmp = T - v1[i];

		result += upper_bound(v2.begin(), v2.end(), tmp) - lower_bound(v2.begin(), v2.end(), tmp);
	}

	cout << result;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();
	solve();

	return 0;
}