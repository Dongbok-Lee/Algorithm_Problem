#define Max 99999
#include <stdio.h>
int main()
{
    long Num;
    int Move, i;
    scanf("%ld",&Num);
	if(Num==1){
		printf("1");
		return 0;
	}
	
    for(i=1; i<Max; i++){
			int sum, sum2;
			sum=3*(i*i+i);
			sum2=Num-2;
        if(sum>sum2)
				{
            Move=i+1;
            printf("%d",Move);
					return 0;
				}
		}
    
    
}
