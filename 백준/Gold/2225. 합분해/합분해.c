#include <stdio.h>
int main(){
    int N;
    int K;
    long long arr[205][205] = {};
    scanf("%d %d", &N, &K);
    for(int i = 0; i <= N; i++)
        arr[1][i] = 1;
    for(int i = 1; i <= K; i++)
        for(int j = 0; j <= N; j++)
            for(int k = 0; k <= j; k++)
                arr[i][j] += (arr[i-1][j-k]%1000000000);
    printf("%d",arr[K][N]%1000000000);
}