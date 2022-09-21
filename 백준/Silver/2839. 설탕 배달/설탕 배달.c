#include <stdio.h>
int main()
{
   int sugar, min, Three, Five, i, j;
   min=9999;
   scanf("%d",&sugar);
   Three=sugar/3;
   Five=sugar/5;
   for(i=0; i<=Three; i++)
       for(j=0; j<=Five; j++)
       {
           if(sugar-3*i-5*j==0)
              if(min>i+j)
                  min=i+j;
       }
    if(min==9999)
        printf("-1");
	else
		printf("%d",min);
    return 0;
       
}
