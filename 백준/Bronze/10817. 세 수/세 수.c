#include<stdio.h>
int main()
{
    int a,b,c,d,e=0;
    int f[3];
    for(a=0; a<3; a++)
    {
        scanf("%d",&b);
        f[a]=b;
    }
    for(a=0; a<2; a++)
    {
        for(b=0; b<2; b++)
            if(f[b]<f[b+1])
            { c=f[b];
            f[b]=f[b+1];
            f[b+1]=c;
            }
    }
    printf("%d",f[1]);
    return 0;
}