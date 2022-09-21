#include<stdio.h>
int main()
{
    int a,b,c, Case ;
    double avr,sum=0,suc=0,student, score[1000];
    scanf("%d",&Case);
    for(a=0; a<Case; a++)
    { suc=0; avr=0; sum=0;
        scanf("%lf",&student);
    
        for(b=0; b<student; b++)
        {
            scanf("%lf",&score[b]);
            sum+=score[b];
        }
        avr=sum/student;
        for(c=0; c<student; c++)
        {
            if(avr<score[c])
						suc+=1;
					
        }
        printf("%.3lf%\n",suc/student*100);
    }   
}