#include <iostream>

using namespace std;
int N, S;
int result = 0;
int sum = 0;
int arr[21];

int init(){

    cin >> N >> S;

    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }

    return 0;
}

int dfs(int v, int sum){

    if(sum == S){
        result ++;
    }

    for(int i = 1; i+v < N; i++){
        dfs(v+i, sum+arr[v+i]);
    }

    return 0;
}

int main(){

    init();

    for(int i = 0; i < N; i++){
            dfs(i,arr[i]);
    }
    
    cout << result;
}