#include<stdio.h>
int main()
{
	int A ,B, C, Point;
	scanf("%d %d %d",&A, &B, &C);
	if(B==C)
	{
		printf("-1");
		return 0;
	}
	Point=A/(C-B)+1;
	if(Point>0)
	printf("%d", Point);
	else if(Point<0)
	printf("-1");
}