#include<iostream>
#include<vector>
#include<deque>
#include<string>

using namespace std;

bool reversed = false;
int T, n;
string p;
string s;
string num;
deque<int> v;

void solve();

void solve() {
	cin >> p;
	cin >> n;
	cin >> s;

	for (int i = 1; i < s.size(); i++) {
		if (isdigit(s[i]))
			num += s[i];
		else {
			if (!num.empty()) {
				v.push_back(stoi(num));
				num.clear();
			}
		}
		
	}

	for (int i = 0; i < p.size(); i++) {
		if (p[i] == 'R') 
			reversed = !reversed;
		else if (p[i] == 'D') {
			if (v.empty()) {
				cout << "error\n";
				return;
			}
			else {
				if (reversed)
					v.pop_back();
				else
					v.pop_front();
			}
		}
	}

	cout << '[';
	if (!v.empty()) {
		if (reversed) {
			for (int i = v.size() - 1; i > 0; i--) {
				cout << v[i] << ',';
			}
			cout << v[0];
		}
		else {
			for (int i = 0; i < v.size() - 1; i++) {
				cout << v[i] << ',';
			}
			cout << v[v.size() - 1];
		}
	}
	cout << "]\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> T;
	for (int i = 0; i < T; i++) {
		reversed = false;
		p.clear();
		s.clear();
		v.clear();
		solve();
	}
	return 0;
}