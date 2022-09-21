#include<stdio.h>

int sumF(int num, int sum)
{			int a,b,c;    
        a=num/100;
        b=num/10%10;
        c=num%10;
        if(c-b==b-a)
        sum+=1;  
 		return sum;
}

int main()
{
    int a,Snum,Mnum,Sum=0;
    scanf("%d",&Snum);
    if(Snum<100)
        printf("%d",Snum);
    if(Snum>=100)
    {
			Sum=99;
    for(a=100; a<=Snum; a++)
        Sum=sumF(a,Sum);
        
    printf("%d",Sum);
    }
    return 0;
}