#include <iostream>

using namespace std;

int N, M;
int sum = 0;
int result = 0;
int arr[10001];

int init(){
    cin >> N >> M;

    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    return 0;
}

int solve(){
    for(int i = 0; i < N; i++){
        for(int j = i; j < N; j++){
            sum += arr[j];
            if(sum == M)
            result++;
        }
        sum = 0;
    }
    return 0;
}

int main(){
    
    init();

    solve();

    cout << result;

    return 0;
}
//2021-09-02 solved
