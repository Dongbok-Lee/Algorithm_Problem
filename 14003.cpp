#include<iostream>
#include<vector>
#include<algorithm>
#define MAX 1000001 

using namespace std;

int N;
int arr[MAX] = {0, };
int idx[MAX] = { 0, };
int result;
vector<int> result_arr;
vector<int> v;


void init();
void solve();

void init() {
	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> arr[i];
}

void solve() {
	v.push_back(arr[0]);
	idx[0] = 1;
	for (int i = 1; i < N; i++) {
		if (v[v.size()-1] < arr[i]) {
			v.push_back(arr[i]);
			idx[i] = v.size();
		}
		else if(v[v.size()-1] == arr[i]) {
			idx[i] = v.size();
		}
		else {
			int index = lower_bound(v.begin(), v.end(), arr[i]) - v.begin();
			v[index] = arr[i];
			idx[i] = index+1;
		}
	}

	result = v.size();
	cout << result << "\n";

	for (int i = N - 1; i >= 0; i--) {
		if (idx[i] == result) {
			result_arr.push_back(arr[i]);
			result--;
		}
	}

	for (int i = result_arr.size() - 1; i >= 0; i--) {
		cout << result_arr[i] << " ";
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	init();
	solve();

	return 0;
}//2022-03-16 solved
