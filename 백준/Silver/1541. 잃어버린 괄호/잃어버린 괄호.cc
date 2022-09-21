#include<iostream>
#include<vector>
#include<queue>
#include<string>

using namespace std;

string s;
string num;
int result = 0;

void solve();

void solve() {
	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] != '+' && s[i] != '-')
			num += s[i];
		else {
			result += stoi(num);
			num.clear();
			//마이너스 나오면 뒤에 나오는 수 모두 빼기
			if (s[i] == '-') {
				for (int j = i + 1; j < s.size(); j++) {
					if (s[j] != '+' && s[j] != '-')
						num += s[j];
					else {
						result -= stoi(num);
						num.clear();
					}
				}
				result -= stoi(num);
				cout << result;
				return;
			}		
		}
	}
	result += stoi(num);
	cout << result;
}
int main() {
	solve();
	return 0;
}