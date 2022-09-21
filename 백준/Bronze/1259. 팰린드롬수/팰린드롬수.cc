#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

void solve();

void solve() {
	string tmp;
	while (1) {
		cin >> tmp;
		if (tmp == "0") {
			break;
		}
		string tmp2;

		for (int i = tmp.length()-1; i >= 0; i--) {
			tmp2  += tmp[i];
		}
		if (!tmp2.compare(tmp)) {
			cout << "yes" << "\n";
		}
		else {
			cout << "no" << "\n";
		}
	}
}

int main() {
	solve();
	return 0;
}