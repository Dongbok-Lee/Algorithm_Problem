#include<stdio.h>
int main(){
    long long i, num;
    long long arr[1003];
    scanf("%lld",&num);
    arr[1]=1;
    arr[2]=2;
    for(i=3; i<=num; i++){
        arr[i]=(arr[i-1]+arr[i-2])%10007;
    }
    printf("%lld",arr[num]);
}