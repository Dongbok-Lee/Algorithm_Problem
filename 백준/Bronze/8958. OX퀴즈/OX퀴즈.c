#include<stdio.h>
int main()
{
    int a,b, Case,Score[81];
    char OX[81];
    scanf("%d",&Case);
    for(a=0; a<Case; a++)
    {
        int plus=0,Score1=0;
        scanf("%s",OX);   
        
         for(b=0; b<20000; b++)
        {
					 
           if(OX[b]=='O')
            {
             Score1+=1+plus;
             plus+=1;
            }
            else if(OX[b]=='X')
            {
               plus=0;
            }
            else{
                Score[a]=Score1;
                printf("%d\n",Score[a]);
                break;
            }
        }  
    }
    return 0;
}