#include <iostream>
#include <vector>
#include <stack>

using namespace std;

void init();
void solve();
bool is_Operator(char);

string arr;
stack<char> S;
char Oper[6] = { '+', '-', '*', '/', '(', ')' };

void init() {
	cin >> arr;
}

void solve() {
	for (int i = 0; i < arr.size(); i++) {
		if (is_Operator(arr[i])) {
			if (S.empty()) {
				S.push(arr[i]);
			}
			else if (arr[i] == '-' || arr[i] == '+') {
			
				while (!S.empty() && S.top() != '(') {
					cout << S.top();
					S.pop();
				}
				S.push(arr[i]);
			}
			else if (arr[i] == '*' || arr[i] == '/') {
				if (S.top() == '*' || S.top() == '/') {
					cout << S.top();
					S.pop();
					S.push(arr[i]);
				}
				else {
					S.push(arr[i]);
				}
			}
			else if (arr[i] == ')') {
				while (!S.empty() && S.top() != '(') {
					cout << S.top();
					S.pop();
				}
				S.pop();
			}
			else {
				S.push(arr[i]);
			}
		}
		else {
			cout << arr[i];
		}
	}

	while (!S.empty()) {
		cout << S.top();
		S.pop();
	}
}

bool is_Operator(char c) {
	for (int i = 0; i < 6; i++) {
		if (c == Oper[i])
			return true;
	}
	return false;
}


int main() {
	init();
	solve();
	return 0;
}