#include <stdio.h>
int main ()
{
    int a,b;
    scanf("%d",&b);
    for(a=1; a<10; a++)
        printf("%d * %d = %d\n",b,a,a*b);
    return 0;
}