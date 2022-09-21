#include<stdio.h>
int main()
{
    int a,b,c=0;
    for(a=0; a<5; a++)
    {
        scanf("%d",&b);
    if(b<40)
            b=40;
        c=c+b;
    }
    printf("%d",c/5);
    return 0;
}