#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

int M, num;
bool S[21] = {0, };
string command;

void init();
void solve();

void init() {
	cin >> M;
}

void solve() {
	for (int i = 0; i < M; i++) {
		cin >> command;
		
		if (command == "add") {
			cin >> num;
			S[num] = true;
		}
		else if(command == "remove") {
			cin >> num;
			S[num] = false;
		}
		else if (command == "check") {
			cin >> num;
			S[num] == true ? cout << 1<< "\n" : cout << 0 << "\n";
		}
		else if (command == "toggle") {
			cin >> num;
			S[num] == true ? S[num] = false : S[num] = true;
		}
		else if(command == "all") {
			for (int j = 1; j < 21; j++) {
				S[j] = true;
			}
		}
		else if (command == "empty") {
			for (int j = 1; j < 21; j++) {
				S[j] = false;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	init();
	solve();
}