#include <stdio.h>
int main()
{
	int i, T, x, y, move;
	long long odd, j ;
	scanf("%d",&T);
	for(i=0; i<T; i++)
	{
		scanf("%d %d",&x, &y);
		move=y-x;
		if(move<=3)
						printf("%d\n",move);
		else
		{
		for(j=1; j<50000; j++)
		{
			odd=j*j+j;
			if(odd>=move)
				break;
		}
		if(odd-j>=move)
			printf("%d\n",j*2-1);
		else
			printf("%d\n",j*2);
		}
	}
}