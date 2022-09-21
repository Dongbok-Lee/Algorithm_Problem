#include<stdio.h>
int main()
{
    int a,b,max=-1000000,min=1000001;
    scanf("%d",&a);
	  int num[a];
    for(b=0; b<a; b++)
    {
        scanf("%d",&num[b]);
        if(max<num[b])
            max=num[b];
        if(min>num[b])
            min=num[b];
    }
    printf("%d ",min);
    printf("%d",max);
   return 0;
}