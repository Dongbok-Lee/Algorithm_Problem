#include<stdio.h>
int main()
{
    int num1,num2,num3,a,b;
    scanf("%d %d %d",&num1,&num2,&num3);
    int sum2 ,sum3=0;
    int sum=num1*num2*num3;
    int arr[100];
        arr[0]=sum%10;
    int sizearr;
	sum2=sum;
   
  for(a=0; a<100; a++)
    {    
        
				sum2/=10;
        arr[a+1]=sum2%10;
        if(sum2/10==0)
        {
            sizearr=a;
            break;
        }
    }
    for(a=0; a<10; a++)
    {
        for(b=0; b<=sizearr+1; b++)
        {
        if(arr[b]==a)
        {
            sum3+=1;
        }
        }
        printf("%d\n",sum3);
        sum3=0;
}
      
}