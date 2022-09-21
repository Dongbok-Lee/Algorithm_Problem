#include<stdio.h>
int main(){
    int tCase;
    int num;
    long long arr[105] = {};
    scanf("%d",&tCase);
    for(int i = 0; i < tCase; i++){
        scanf("%d",&num);
        arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2;
        for(int j = 6; j <= num; j++){
                arr[j] = arr[j-5] + arr[j-1];
        }
        printf("%lld\n",arr[num]);
    }
}