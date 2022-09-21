#include<stdio.h>
int comp(int x, int y){return x>y ? x:y;}
int main(){
    int num;
    int stair[305] = {};
    int maxArr[305] = {};
    int max;
    scanf("%d",&num);
    for(int i = 1; i <= num; i++)
        scanf("%d",&stair[i]);
    maxArr[1] = stair[1]; maxArr[2] = stair[1] + stair[2];
    for(int i = 3; i <= num; i++)
        maxArr[i]=comp(maxArr[i-3] + stair[i-1] + stair[i], maxArr[i-2]+stair[i]);
    printf("%d",maxArr[num]);
    return 0;
}