#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 4000

using namespace std;

long long arr[4][MAX];
long long result = 0;
int N;

vector<long long> v;

int init(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    for(int i = 0; i < N; i++)
        for(int j = 0; j < 4; j++)
            cin >> arr[j][i];
    
    return 0;
}

int solve(){
for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            v.push_back(arr[2][i] + arr[3][j]);


    sort(v.begin(), v.end());

    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++){

            long long half = arr[0][i] + arr[1][j];
            long long low = lower_bound(v.begin(), v.end(), -half) - v.begin();
            long long high = upper_bound(v.begin(), v.end(), -half) - v.begin();

            if(-half == v[low])
                result += (high - low);
        }
    return 0;
}

int main(){

    init();
    solve();
    
    cout << result;

    return 0;
}   