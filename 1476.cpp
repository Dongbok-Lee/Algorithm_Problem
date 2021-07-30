#include <iostream>

using namespace std;

int E, S, M;
int x = 1;

int main(){

	cin >> E >> S >> M;

	while(1){
		int a = x % 15;
		if(a == 0) a = 15;
		int b = x % 28;
		if(b == 0) b = 28;
		int c = x % 19;
		if(c == 0) c = 19;
		
		if(a == E && b == S && c ==M){
			cout << x;
			break;
		}
		x++;
	}
	return 0;
}
//2021 - 07 - 28 solved
