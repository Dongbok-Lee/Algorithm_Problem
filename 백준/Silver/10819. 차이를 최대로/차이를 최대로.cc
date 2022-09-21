#include<iostream>
#include<algorithm>
#include<cstdlib>

using namespace std;

int N;
int arr[10];
int result = 0;

int main(){

    cin >> N;

    for(int i = 0; i < N; i++) cin >> arr[i];

    sort(arr,arr+N);

    do{
        int x = 0;
        for(int i = 0; i < N-1; i++) x += abs(arr[i]-arr[i+1]);
        result = max(x, result);
    }while(next_permutation(arr,arr+N));

    cout << result;

    return 0;
}