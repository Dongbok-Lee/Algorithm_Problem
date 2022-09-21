#include<stdio.h>
#define Mnum 10003
int comp(int x,int y){return x>y ? x:y;}
int main(){
    int num, Max[Mnum], i, j, arr[Mnum];
    scanf("%d",&num);
    for(i=1; i<=num; i++)
      scanf("%d",&arr[i]);
    arr[0]= 0; Max[1]=arr[1]; Max[2]=arr[1]+arr[2];
    for(i=3; i<=num; i++){
        Max[i]=comp(Max[i-2]+arr[i],Max[i-3]+arr[i-1]+arr[i]);
        Max[i]=comp(Max[i-1],Max[i]);
    }
    printf("%d",Max[num]);
    return 0;
}