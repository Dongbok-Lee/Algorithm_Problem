#include<stdio.h>

int main()

{
int i, num, sum = 0;
char word[ 50 ];
scanf("%s",word);
for(i = 0; word[ i ]; i++)
{
num=0;
if(word[ i ]<80)
{
num = (word[ i ]-62)/3+1;
sum += num+1;
}
else if(word[ i ]<84)
sum += 8;
else if(word[ i ]<87)
sum += 9;
else
sum += 10;
}
	printf("%d",sum);
}