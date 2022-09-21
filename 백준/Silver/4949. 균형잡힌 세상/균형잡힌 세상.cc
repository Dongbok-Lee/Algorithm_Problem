#include<iostream>
#include<stack>
#include<algorithm>
#include<cmath>
#include<string>

using namespace std;

void solve();

void solve() {
	
	string s;
	bool success = 0;
	while (1) {
		getline(cin, s);
		if (s == ".")
			return;
		stack<int> small;
		stack<int> big;
		for (int i = 0; i < s.size(); i++) {
			success = 0;
			if (s[i] == '(') {
				small.push(i);
			}

			if (s[i] == ')') {
				if (small.empty()) {
					cout << "no\n";
					break;
				}
				else if (!big.empty()) {
					if (big.top() > small.top()) {
						cout << "no\n";
						break;
					}
					else
						small.pop();
				}
				else {
					small.pop();
				}
			}

			if (s[i] == '[') {
				big.push(i);
			}

			if (s[i] == ']') {
				if (big.empty()) {
					cout << "no\n";
					break;
				}
				else if (!small.empty()) {
					if (big.top() < small.top()) {
						cout << "no\n";
						break;
					}
						
					else
						big.pop();
				}
				else {
					big.pop();
				}
			}
			if (i == s.size() - 1)
				success = true;
		}
		if (success && small.empty() && big.empty()) {
			cout << "yes\n";
		}
		else if (success && (!small.empty() || !big.empty()))
			cout << "no\n";
	}

}

int main() {
	solve();
	return 0;
}