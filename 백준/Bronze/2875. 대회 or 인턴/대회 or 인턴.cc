#include<iostream>
#include<algorithm>

using namespace std;

int N, M, K;
int result = 0;
int main(){
    
    cin >> N >> M >> K;

    int team = min(N/2,M);

    if(N+M-team*3-K >= 0){
        cout << team;
    }
    else{
        cout << team-1+((N+M-team*3-K)+1)/3;
    }
}
