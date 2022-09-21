#include<iostream>

using namespace std;

int K,N;
long long m;
long long length[10001];
long long longest = 0;
long long result = 0;

int b_search(long long s, long long l){
	if(l < s)
		return 0;

	long long sum = 0;

	m = (s+l)/2;

	for(int i = 0; i < K; i++){
		sum += length[i]/m;
	}

	 if(sum < N ){
		b_search(s, m-1);
	}else{
		if(result < m)
			result = m;
		b_search(m+1,l);
	}
	return 0;
}

int main(){

	cin >> K >> N;

	for(int i = 0; i < K; i++){
		cin >> length[i];
	
		if(length[i] > longest)
			longest = length[i];
	}

	b_search(1,longest);

	cout << result;

	return 0;
}