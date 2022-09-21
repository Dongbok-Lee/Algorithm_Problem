#include<stdio.h>
int main()
{
 int a,b,c=0;
    scanf("%d",&a);
    for(b=1; b<=a; b++)
        c=c+b;
    printf("%d",c);
    return 0;
}