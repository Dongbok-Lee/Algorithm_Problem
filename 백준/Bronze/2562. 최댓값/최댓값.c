#include<stdio.h>
int main()
{    
    int num=9,b,max=0;
    int arr[9];
    for(b=0; b<num; b++)
    {
       scanf("%d",&arr[b]);
       if(max<arr[b])
           max=arr[b];
    }
	 
    printf("%d\n",max);
	for(b=0; b<num; b++)
    {
       if(max==arr[b])
				 printf("%d",b+1);
    }
    return 0;
    
}