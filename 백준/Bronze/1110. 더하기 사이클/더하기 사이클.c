#include<stdio.h>
int main ()
{
    int a,b,c,d,e,f=0;
    scanf("%d",&a);
     b=a;
    f=0;
    do{
			c=b/10;
      d=b%10;
      e=c+d;
      b=(d*10)+(e%10);
        f++;
      if(b==a)
      {
          printf("%d",f);
          return 0;
      }
    }while(b!=a);
}