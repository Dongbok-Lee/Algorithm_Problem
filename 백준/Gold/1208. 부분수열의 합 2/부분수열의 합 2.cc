#include<iostream>
#include<vector>
#include <map>

using namespace std;

vector<int> v;

int N, S, half;
long long result;
map <int, int> mp;

int dfsLeft(int idx, int sum){
    if(idx == half){
        mp[sum]++;
        return 0;
    }
    dfsLeft(idx+1, sum);
    dfsLeft(idx+1, sum + v[idx]);
    return 0;
}

int dfsRight(int idx, int sum){
    if(idx == N){
        result += mp[S-sum];
        return 0;
    }
    dfsRight(idx+1, sum);
    dfsRight(idx+1,sum+v[idx]);
    return 0;
}

int main(){
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> N >> S;
	half = N/2; v.resize(N);
	for(int i=0; i<N; i++) cin >> v[i];
	dfsLeft(0, 0);
	dfsRight(half, 0);
	if(S == 0) result--;
	cout << result;

    return 0;
}