#include<stdio.h>
int main(){
    int tCase, num, i, j, arr[15];
    scanf("%d",&tCase);
    arr[0]=1;
    arr[1]=1;
    arr[2]=2;
    for(j=3; j<15; j++){
        arr[j]=arr[j-1]+arr[j-2]+arr[j-3];
    }
    for(i=0; i<tCase; i++){
        scanf("%d",&num);
        printf("%d\n",arr[num]);
    }
}