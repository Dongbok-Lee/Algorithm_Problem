#include <iostream>
#include <algorithm>
using namespace std;

void init();
void solve();

string arr;
string arr2;
int result;

void init() {
	cin >> arr;
	cin >> arr2;
}

void solve() {
	if (arr.size() < arr2.size()) cout << "no";
	else cout << "go";
}

int main() {
	init();
	solve();
}