#include<stdio.h>
int main()
{
   double max=0,b=0, score[1000],score2[1000];
  	int subnum,a;
    scanf("%d",&subnum);
    for(a=0; a<subnum; a++)
    {
        scanf("%lf",&score[a]);
        if(max<score[a])
            max=score[a];
     }
        for(a=0; a<subnum; a++)
    {
					
          score2[a]=score[a]/max*100;
			
				
     }
    for(a=0; a<subnum; a++)
    {
        b+=score2[a];
    }
    printf("%lf",b/subnum);
    
    
}