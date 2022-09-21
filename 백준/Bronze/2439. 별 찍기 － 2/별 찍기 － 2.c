#include<stdio.h>
int main()
{
    int a,b,c,d,f;
    scanf("%d",&a);
    for(b=0; b<a; b++)
    {
        for(f=b+1; f<a; f++)
        {
            printf(" ");
        }
			 for(c=b; c>=0; c--)
        {
            printf("*");
        }
			printf("\n");
    }
    return 0;
}