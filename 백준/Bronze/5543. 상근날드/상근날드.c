#include<stdio.h>
int main ()
{
    int a,b,c,e=0;
    c,e=3000;
    for(a=0; a<3; a++)
    {
        scanf("%d",&b);
        if(c>b)
            c=b;
    }
    for(a=0; a<2; a++)
    {
        scanf("%d",&b);
        if(e>b)
            e=b;
    }
    printf("%d",c+e-50);
    
}