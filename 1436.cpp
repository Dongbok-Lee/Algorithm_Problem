#include <iostream>
#include <string>

using namespace std;

int N;

void init();
void solve();

void init() {
	cin >> N;
}

void solve() {
	int title = 665;
	while (N != 0) {

		title++;

		string tmp = to_string(title);
		for (int i = 0; i < tmp.size() - 2; i++) {
			if (tmp[i] == '6' && tmp[i + 1] == '6' && tmp[i + 2] == '6') {
				N--;
				break;
			}
		}
	}
	cout << title;
}

int main() {
	init();
	solve();

	return 0;
}//2022-03-18 solved
