#include<stdio.h>
#define max 100006
int comp(int x,int y){return x>y ? x:y;}
int main(){
    int tCase, N, arr[2][max], i, j, k, arr2[2][max];
    scanf("%d",&tCase);
    for(i=1; i<=tCase; i++){
        scanf("%d",&N);
        for(j=0; j<2; j++) 
            for(k=1; k<=N; k++) scanf("%d",&arr[j][k]);
        arr2[0][0]=arr2[1][0]=0;
        arr2[0][1]=arr[0][1]; arr2[1][1]=arr[1][1];
        for(k=2; k<=N; k++){
            arr2[0][k]=comp(arr2[1][k-1],arr2[1][k-2])+arr[0][k];
            arr2[1][k]=comp(arr2[0][k-1],arr2[0][k-2])+arr[1][k];
        }
        printf("%d\n",comp(arr2[0][N],arr2[1][N]));
    }
}