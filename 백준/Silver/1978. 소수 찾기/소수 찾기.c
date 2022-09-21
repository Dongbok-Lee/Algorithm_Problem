#include <stdio.h>
int main()
{
	int i, j, N, A, mino=0, count=0;
	scanf("%d",&N);
	for(i=0; i<N; i++)
	{
		scanf("%d",&A);
		if(A==1)
			;
		else if(A==2)
			mino+=1;
		else{
		for(j=2; j<A; j++)
		{
			if(A%j==0)
				count+=1;
		}
		if(count==0)
				mino+=1;
		count=0;
		}
	}
	printf("%d",mino);
	return 0;
}