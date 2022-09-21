#include<stdio.h>
int main()
{
    int i,sum=0,b;
    for(i=0; i<5; i++)
    {
        scanf("%d",&b);
       sum+=b*b;
    }
    printf("%d",sum%10);
    
}