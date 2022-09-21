#include<stdio.h>
int Sum(int Num,int Count, int Sum)
{
	int i;
	 for(i=0; i<Count; i++){
		 scanf(" %c",&Num);
			Sum+=(Num-48);
    }
	return Sum;
}

int main()
{
    int count,sum=0,num=0;
    scanf("%d",&count);
    sum=Sum(num,count,sum);
    printf("%d",sum);
    return 0;
}