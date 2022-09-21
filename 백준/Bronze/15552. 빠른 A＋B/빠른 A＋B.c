#include<stdio.h>
int main ()
{
    int a,b,c,d=0;
    scanf("%d",&a);
    for(b=0; b<a; b++)
    {
    scanf("%d %d",&c,&d);
    printf("%d\n",c+d);
}
    return 0;
}