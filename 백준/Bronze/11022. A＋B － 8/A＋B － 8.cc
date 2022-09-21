#include<stdio.h>
int main ()
{
    int a,b,c,d;
    scanf("%d",&a);
    for(b=0; b<a; b++)
    {
        scanf("%d %d",&c,&d);
        printf("Case #%d: %d + %d = %d\n",b+1,c,d,c+d);
}
return 0;}