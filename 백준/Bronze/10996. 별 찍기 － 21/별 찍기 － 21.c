#include<stdio.h>
int main()
{
    int a,b,c,d;
    scanf("%d",&a);
    for(b=0; b<2*a; b++)
    {
			if(b%2==0){
      for(c=1; c<a+1; c++)
      {  if(c%2==1)
              printf("*");
              else
                  printf(" ");
    }
			printf("\n");
			}
			if(b%2==1){
      for(c=1; c<a+1; c++)
      {  if(c%2==0)
              printf("*");
              else
                  printf(" ");
    }
			printf("\n");
			}
    }
}