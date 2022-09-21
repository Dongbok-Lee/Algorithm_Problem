#include<iostream>

using namespace std;

int N, K;
int cnt = 0;
int coin[11];

int main(){

    cin >>  N >> K;

    for(int i = 0; i < N; i++) cin >> coin[i];

    while(K!=0){
        for(int i = 0; i<N; i++){
        
        if(i == N-1){

                cnt += K/coin[i];
                K = K%coin[i];

        }
        else if(K<coin[i+1]){

                cnt += K/coin[i];
                K = K%coin[i];

        }
            
        }
    }
    cout << cnt;
    return 0;
}