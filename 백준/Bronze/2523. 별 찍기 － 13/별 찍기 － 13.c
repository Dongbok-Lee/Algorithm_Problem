#include<stdio.h>
int main()
{
    int a,b,c;
    scanf("%d",&a);
    for(b=0; b<a; b++)
		{  for(c=0; c<b+1; c++)
            printf("*");
		printf("\n");
		}
    for(b=a-1; b>0; b--)
		{for(c=0; c<b; c++)
            printf("*");
		printf("\n");}
        
}
