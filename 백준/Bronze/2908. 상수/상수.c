#include<stdio.h>
int calc(int num)
{
    int a,b,c,sum;
    a=num/100;
    b=num/10%10;
    c=num%10;
        sum=c*100+b*10+a;
    return sum;
}
int main(){
    int first,second;
    scanf("%d %d",&first,&second);
    first=calc(first);
    second=calc(second);
    if(first>second)
        printf("%d",first);
        else
            printf("%d",second);
    
}