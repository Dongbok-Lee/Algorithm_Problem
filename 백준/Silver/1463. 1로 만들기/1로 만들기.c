#include<stdio.h>
#define MIN(a,b)(a>b ? b:a)
#define MAX 10000000
int main(){
    int a=MAX, b=MAX, c=MAX, i, num, arr[1000001];
    scanf("%d",&num);
    arr[1]=0;
    arr[2]=1;
    arr[3]=1;
    for(i=4; i<=num; i++){
        if(i%2==0){
            a=arr[i/2]+1;
        }
        if(i%3==0){
            b=arr[i/3]+1;        
        }
        c=arr[i-1]+1;
        arr[i]=MIN(MIN(a,b),MIN(b,c));
        a=MAX;
        b=MAX;
        c=MAX;
    }
    printf("%d",arr[num]);
}