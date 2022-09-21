#include <stdio.h>
int main()
{
	char str[ 107 ];
	int i, j, k, sum = 0, check, num;
	scanf("%d", &num);
	for(i = 0; i<num; i++)
	{ 
	 		For:
			scanf("%s", str);
			for(j = 0; str[ j ]; j++)
			{
				check=0;
				if( j == 0 || str[ j-1 ] != str[ j ])
				{
					for(k = j+1; str[ k ]; k++)
					{
						if(str[ k ] == str[ j ] && str[ k-1 ] != str[ j ])
						{
						sum++;
						check=1;
						break;
						}
						
				
					}
				}
				if(check==1)
							break;
			}
	}
	printf("%d",num-sum);
}