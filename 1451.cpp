#include<iostream>

using namespace std;

int N, M;
int square[102][102];
long long result = 0;

int splus(int a,int b,int c,int d){
    int cnt = 0;
    for(int k = a; k < c; k++) for(int l = b; l < d; l++) cnt += square[k][l];
    return cnt;
}

int count(){

    for(int i = 1; i < N; i++){
        for(int j = 1; j < M; j++){
            long long asq, bsq, csq;

            asq = splus(0,0,i,j);
            bsq = splus(i,0,N,j);
            csq = splus(0,j,N,M);

            if(result < asq * bsq * csq)
                result = asq * bsq * csq;

            asq = splus(0,0,i,j);
            bsq = splus(0,j,i,M);
            csq = splus(i,0,N,M);

            if(result < asq * bsq * csq)
                result = asq * bsq * csq;

            asq = splus(0,0,i,M);
            bsq = splus(i,0,N,j);
            csq = splus(i,j,N,M);

            if(result < asq * bsq * csq)
                result = asq * bsq * csq;

            asq = splus(0,0,N,j);
            bsq = splus(0,j,i,M);
            csq = splus(i,j,N,M);

            if(result < asq * bsq * csq)
                result = asq * bsq * csq;
        }
    }
    return 0;
}

int count2(){
    long long asq,bsq,csq;
    for(int i = 1; i < N-1; i++) for(int j = i+1; j < N; j++){
            asq = splus(0,0,i,M);
            bsq = splus(i,0,j,M);
            csq = splus(j,0,N,M);
            
            if(result < asq * bsq * csq)
                result = asq * bsq * csq;
    }
    for(int i = 1; i < M-1; i++) for(int j = i+1; j < M; j++){
            asq = splus(0,0,N,i);
            bsq = splus(0,i,N,j);
            csq = splus(0,j,N,M);
            
            if(result < asq * bsq * csq)
                result = asq * bsq * csq;
    }
    return 0;
}

int main(){

    cin >> N >> M;

    for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) scanf("%1d",&square[i][j]);

    count();
    count2();

    cout << result;
}
//2021-07-30 solved
