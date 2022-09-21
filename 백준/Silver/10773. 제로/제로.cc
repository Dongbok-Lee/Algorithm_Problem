#include<iostream>
#include<stack>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

stack<int> s;
int N;

void solve();

void solve() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;

		if (num == 0)
			s.pop();
		else
			s.push(num);
	}
	int sum = 0;
	for (int i = 0; i < s.size(); i++) {
		while (!s.empty()) {
			sum += s.top();
			s.pop();
		}
	}
	cout << sum;
}

int main() {
	solve();
	return 0;
}