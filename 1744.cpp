#include <iostream>
#include<algorithm>
#include<vector>

using namespace std;

int N;
int result = 0;
vector<int> pnum;
vector<int> nnum;

int calc(vector<int> num){

		while(num.size() > 1){
		int p1 = num.back();
		num.pop_back();
		int p2 = num.back();
		num.pop_back();

		result += p1*p2;
	}

	if(num.size()==1){
		result += num.back();
		num.pop_back();
	}

	return 0;
}

int main(){

	cin >> N;

	for(int i = 0; i < N; i++){
		int x;
		cin >> x;

		if(x > 1){
			pnum.push_back(x);
		} 

		else if(x <= 0){
			nnum.push_back(x);
		}

		else{
			result++;
		}
	}

	sort(pnum.begin(),pnum.end());
	sort(nnum.begin(),nnum.end(),greater<int>());

	calc(pnum);
	calc(nnum);

	cout << result;
	
	return 0;
}
//2021 - 07 -28 solved
