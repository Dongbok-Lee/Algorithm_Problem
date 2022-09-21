#include<stdio.h>
int main()
{
    int i, a, b, num, h, t;
    scanf("%d",&num);
    for(i=0; i<9999; i++)
    {
        
        if((i*(i+1))/2<num)
        {
            t=(i*(i+1))/2;
        }
        else
            break;
    }
    h=num-t;
	a=h;
	b=i-h+1;
	if(i%2==0)
    printf("%d/%d",h,i-h+1);
	else
		printf("%d/%d",b,a);
    return 0;
}