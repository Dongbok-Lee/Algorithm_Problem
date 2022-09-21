#include <iostream>
#include <algorithm>
#define MAX 500000

using namespace std;

int N,M;
int sang[MAX];
int num[MAX];

 int b_search(int l, int r, int n){

	int m;
	m= (l+r) / 2;

	if(sang[m] == n){
		cout << 1 << " ";
		return 0;
	}

	if(l>r){
			cout << 0 << " ";
			return 0;
	}
	else if(sang[m] < n){
		b_search(m+1, r, n);
	}
	else{
		b_search(l, m-1, n);
	}
	return 0;
}

int main(){
	
	//input
	cin >> N;
	for(int i = 0; i < N; i++) cin >> sang[i];
	cin >> M;
	for(int j = 0; j < M; j++) cin >> num[j];

	sort(sang, sang+N);

	for(int i = 0; i < M; i++){
		b_search(1, N, num[i]);
	}


	return 0;
}