#include<iostream>
using namespace std;

int main(){
	int n, a, b, chang = 100, sang = 100;
	cin >> n;
	for(int i = 0; i <n ; i++){
		cin >> a >> b;
		if(a>b){
			sang -= a;
		}else if(a<b){
			chang -= b;
		}
	}
	cout << chang << endl << sang;
}