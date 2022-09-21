#include <stdio.h>
#define MAX 1000003

int main() {
	int i, Amax = 0, Abmax = 0, Anum, Bnum, Search, BSearch, Alpha[ 28 ] = { 0, };
	char arr[ MAX ] = { 0, };
	fgets(arr, sizeof(arr), stdin);
	for(i =0; arr[ i ]; i++)
	{	
		if(64 < arr[ i ] && arr[ i ] < 95)
		{
			Anum = arr[ i ] - 65;
			Alpha[ Anum ] += 1;  
		}
		else if(arr[ i ] > 95)
		{
			Bnum = arr[ i ] - 97;
			Alpha[ Bnum ] += 1;
		}
	}
	for(i = 0; i < 26; i++){
		if(Alpha[ Amax ] <= Alpha[ i ])
			Amax = i;
	}
	for(i = 0; i < 26; i++){
		if(Alpha[ Abmax ] <= Alpha[ 25 - i ])
			Abmax = 25 - i;
	}
	if(Amax == Abmax)
		printf("%c", Amax+65);
	else
		printf("?");
    return 0;
}
