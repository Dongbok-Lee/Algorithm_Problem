#include<stdio.h>
#define MAX 10000
int calc(int b)
{
    int sum=b;
    int val=0;
    val=b/1000;
    sum+=val;
    val=b/100%10;
    sum+=val;
    val=b/10%10;
    sum+=val;
    val=b%10;
    sum+=val;
    return sum;
}

int main()
{
  int a;
  int arr[MAX+1]={0};
  for(a=0; a<MAX-1; a++)
  {
		if(calc(a+1)<=MAX)
	{
      arr[calc(a+1)]=1;
  }
	}

	
  for(a=1; a<=MAX; a++)
  {
      if(arr[a]==0)
          printf("%d\n",a);
  
	}
    return 0;
}