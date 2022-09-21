#include<iostream>
#include<stack>
#include<algorithm>

using namespace std;

string str, bomb;
string s;

void init();
void solve();
bool same_chk();
void pop_bomb();
void print_stack();

void init() {
	cin >> str >> bomb;
}

void solve() {
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == bomb[bomb.size() - 1] && s.size() >= bomb.size()-1) {
			s += str[i];

			if (same_chk())
				pop_bomb();
		}
		else 
			s += str[i];
	}
	print_stack();
}
// 문자열이 같은지 체크
bool same_chk() {
	for (int i = 0; i < bomb.size(); i++) {
		if (s[s.size() - bomb.size()+i] != bomb[i])
			return false;
	}
	return true;
}

//폭탄크기만큼 스택 POP
void pop_bomb() {
		s.erase(s.size()-bomb.size(), bomb.size());
}

void print_stack() {

	if (s.size() == 0)
		cout << "FRULA";
	else
		cout << s;
}

int main() {
	init();
	solve();
	return 0;
}