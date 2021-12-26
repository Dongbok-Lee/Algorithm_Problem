#include <iostream>
#include <algorithm>


using namespace std;

int word;
string arr[20005];

bool comp(string, string);
void init();
void solve();

void init() {
	cin >> word;
	for (int i = 0; i < word; i++)
		cin >> arr[i];
}

bool comp(string s1, string s2) {
	if (s1.length() == s2.length()) {
		return s1 < s2;
	}
	return s1.length() < s2.length();
}

void solve() {
	sort(arr, arr+word,comp);
}

int main() {
	init();
	solve();
	for (int i = 0; i < word; i++) {
		if (arr[i] != arr[i + 1])
			cout << arr[i] << "\n";
	}
	return 0;
}//2021-12-26 solved
