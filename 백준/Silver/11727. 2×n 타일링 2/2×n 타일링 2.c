#include<stdio.h>
int main(){
    long long arr[10009];
    int num, i;
    scanf("%d",&num);
    arr[1]=1;
    arr[2]=3;
    for(i=3; i<=num; i++){
        arr[i]=(arr[i-1]+arr[i-2]*2)%10007;
    }
    printf("%d",arr[num]);
}