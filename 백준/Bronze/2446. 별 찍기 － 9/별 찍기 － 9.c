#include<stdio.h>
int main()
{
    int a,b,c,d;
    scanf("%d",&a);
    for(b=0; b<a; b++)
		{  for(c=0; c<b; c++)
            printf(" ");
		   for(d=0; d<((a-b)*2)-1; d++)
				    printf("*");
		printf("\n");
		}
	
    for(b=a-1; b>0; b--)
		{for(c=0; c<b-1; c++)
            printf(" ");
		 for(d=0; d<2*(a-b+1)-1; d++)
			 printf("*");
		printf("\n");}
        
}
