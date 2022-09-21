#include<stdio.h>
int main ()
{
    int a,b,c,d=0;
    scanf("%d %d",&a,&b);
    for(c=0; c<a; c++)
    {
        scanf("%d",&d);
        if(d<b)
            printf("%d ",d);
    }
    return 0;
}