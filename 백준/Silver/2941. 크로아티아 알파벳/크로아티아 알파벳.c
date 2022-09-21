#include<stdio.h>
int main()
{
	char str[ 105 ]={0};
	int i, sum=0;
	fgets(str, 105, stdin);
	for(i = 0; str[i]; i++)
	{
		switch(str[ i ])
		{
			case 'c':
				if(str[ i+1 ]=='='||str[ i+1 ]=='-')
					i++;
				sum+=1;
				break;
			case 'd':
				if(str[ i+1 ]=='z'&&str[ i+2 ]=='=')
					i+=2;
				else if(str[ i+1 ]=='-')
					i++;
				sum+=1;
				break;
			case 'l':
				if(str[ i+1 ]=='j')
					i++;
				sum+=1;
				break;
			case 'n':
				if(str[ i+1 ]=='j')
					i++;
				sum+=1;
				break;
			case 's':
				if(str[ i+1 ]=='=')
					i++;
				sum+=1;
				break;
			case 'z':
				if(str[ i+1 ]=='=')
					i++;
				sum+=1;
				break;
			default:
				if(str[ i ]==0)
					break;
					sum++;
		}
	}
	printf("%d", sum-1);
}