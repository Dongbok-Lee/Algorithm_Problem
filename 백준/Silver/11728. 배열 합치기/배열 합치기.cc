#include <iostream>
#define MAX 1000001

using namespace std;

int N, M;
int x = 0, y = 0;
int arr1[MAX] = {}, arr2[MAX]= {};

int main(){
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	
	cin >> N >> M;

	for(int i = 0; i < N; i++) cin >> arr1[i];
	for(int j = 0; j < M; j++) cin >> arr2[j];

	while(x < N && y < M){
		
		if(arr1[x] >= arr2[y])
			cout << arr2[y++] << " ";
		else
			cout << arr1[x++] << " ";
	}
	while(x < N) cout << arr1[x++] << " ";
	while(y < M) cout << arr2[y++] << " ";
	return 0;
}