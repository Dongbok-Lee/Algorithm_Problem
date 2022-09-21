#include<stdio.h>

int main()

{
char word[102]={ -1, };  

int i,length, Alpha[26]={0};
    
for(i=0; i<27; i++)
	Alpha[i]=-1;

scanf("%s",&word);
	
for(i=0; i<102; i++){
	length=i;
	if(word[i]=='\0')
		break;
    }
    
for(i=length-1; i>=0; i--)
    Alpha[word[i]-97]=i;

i=0;

while(i!=26){
    printf("%d ", Alpha[i]);
    i++;
    }


}