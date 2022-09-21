#include<stdio.h>
int main()
{
    int i,j,k, Case,repeat;
    char word[21];
    
    
    scanf("%d",&repeat);
    
 
    for(k=0; k<repeat; k++)
    {
        scanf("%d",&Case);
        scanf("%s",&word);
        for(i=0; i<21; i++){
            if(word[i]=='\0')
                break;
            for(j=0; j<Case; j++)
                printf("%c",word[i]);
        }
			printf("\n");
    }
}