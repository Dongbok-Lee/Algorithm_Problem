#include <iostream>
#include <cstdlib>
#define MAX 500001
using namespace std;

int N;
long long cnt = 0;
int arr[MAX];
int tmp[MAX];

int merge(int start, int end){
	int mid = (start+end)/2;
	int i = start;
	int j = mid+1;
	int k = start;
	
	while(i <= mid && j <= end){
			if(arr[i]>arr[j]){
				tmp[k] = arr[j];
				cnt+=abs(k-j);
				j++;
			}
			else{
				tmp[k] = arr[i];
				cnt+=abs(k-i);
				i++;
			}
			k++;
	}
	if(i > mid){
		for(j; j<=end; j++){ 
			tmp[k] = arr[j];
			cnt+=abs(k-j);
			k++;
		}
		
	}
	else{
		for(i; i<=mid; i++){
			tmp[k] = arr[i];
			cnt+=abs(k-i);
			k++;
		}
	}

	for(int l = start; l <= end; l++) arr[l] = tmp[l];
	return 0;
}

int mergesort(int start, int end){
	int mid = (start+end)/2;
	
	if(start < end){
		mergesort(start,mid);
		mergesort(mid+1,end);
		merge(start,end);
	}

	return 0;
}

int main(){
	cin >> N;
	for(int i = 0; i < N; i++) cin >> arr[i];

	mergesort(0,N-1);
	
	cout << cnt/2;
	return 0;
}