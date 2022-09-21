#include <stdio.h>
#define MAX 1000003
int main()
{
	int i = 0, blank = 0;
	char Sentence[ MAX ];
	fgets(Sentence, sizeof(Sentence), stdin);
	for(i = 0; Sentence[ i ]; i++){
		if(Sentence[ i ]==' ')
			blank++;	
	}
  if(Sentence[0]==' '){
			blank--;
	}
	  
	if(Sentence[ i-2 ]==' ')
		blank--;

	printf("%d",blank+1);
	return 0;
}