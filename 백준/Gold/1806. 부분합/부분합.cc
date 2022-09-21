#include <iostream>
#include <algorithm>

using namespace std;

int MAX = 100000001;
int N , S;
int start = 0, fin = 0, sum = 0, minLen = MAX;

int arr[100001];

int init(){

    cin >> N >> S;

    for(int i = 0; i < N; i++)
        cin >> arr[i];
    return 0;
}

int solve(){
    while(start <= fin){
        if(sum >= S){
            minLen = min(minLen,fin - start);
            sum -= arr[start++];
        }
        else if(fin == N)  break;
        else  sum += arr[fin++];
    }
    if(minLen == MAX)   cout << 0;
    else  cout << minLen;
    return 0;
}

int main(){
    init();
    solve();
    return 0;
}