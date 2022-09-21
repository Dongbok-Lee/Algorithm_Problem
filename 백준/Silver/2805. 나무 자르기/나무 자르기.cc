#include<iostream>

using namespace std;

int N;
long long M;
long long l,m,s;
long long tallest = 0;
long long trees[1000001];

int main(){

	cin >> N >> M;

	for(int i = 0; i < N; i++){
		cin >> trees[i];
		if(tallest < trees[i]) tallest = trees[i];
	}

	s = 1; l = tallest;

	while(s <= l){
		long long sum = 0;

		m = (s+l)/2;

		for(int j = 0; j < N; j++)
			if(trees[j] > m) sum += trees[j]-m;
		
		if(sum < M){
			l = m-1;
		}else{
			s = m+1;
		}
		
	}
	cout << (s+l)/2;
	return 0;
}