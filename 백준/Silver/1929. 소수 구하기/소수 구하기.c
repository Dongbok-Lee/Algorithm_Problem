#include<stdio.h>
int main()
{
	int M, N, i, j, count = 0;
	scanf("%d %d", &M, &N);
	if (M == 2 || M == 1) {
		printf("2\n");
		M = 3;
	}
	for (i = M; i <= N; i++)
	{
		for (j = 2; j < i; j++)
		{
			if ((j*j) > N)
				break;
			else
				if (i%j == 0)
				{
					count = 1;
					break;
				}
		}
			if (count == 0)
				printf("%d\n", i);
			count = 0;
		}
		return 0;
	}

