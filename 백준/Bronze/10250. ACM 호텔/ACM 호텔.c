#include<stdio.h>
int main()
{
	int i, T, W, H, N;
	scanf("%d",&T);
	for(i=1; i<=T; i++)
	{
		scanf("%d %d %d",&W, &H, &N);
		if(N%W==0 && W!=1)
			printf("%d\n",(((N-1)%W+1)*100)+(N/W));
		else if(W==1)
			printf("%d\n",100+N);
		else
			printf("%d\n",(N%W)*100+(N/W)+1);
	}
	return 0;
}