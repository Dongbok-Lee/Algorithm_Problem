#include <iostream>
#include <algorithm>

using namespace std;

int N, C;
int l, m, r;
int result = -1;
int house[200001] = {};

int main(){
	cin >> N >> C;
	for(int i = 0; i < N; i++) cin >> house[i];

	sort(house,house+N);

	l = 1;
	r = house[N-1];

	while(l <= r){
		int cnt = 1;
		int cpos = house[0];

		m = (r+l)/2;

		for(int i = 1; i < N; i++){
			if(house[i]-cpos >= m){
				cnt++;
				cpos = house[i];
			} 
		}
		if(cnt < C){
			r = m-1;
		}else{
			result = m;
			l = m+1;
		}
	}
	
	cout << result;
	return 0;
}