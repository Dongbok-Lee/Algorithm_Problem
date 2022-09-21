#include<stdio.h>
int main ()
{
    int a,sum=0;
    int arr[10];
    int arr2[43]={0};
    for(a=0; a<10; a++)
    {
        scanf("%d",&arr[a]);
        arr2[arr[a]%42]+=1;
    }
    for(a=0; a<43; a++)
    {
        if(arr2[a]!=0)
            sum+=1;    
			
    }
 	
    printf("%d",sum);
}