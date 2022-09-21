#include<stdio.h>
int main()
{
    int arr[9], i,a=0,d=0;
    for(i=0; i<8; i++){
        scanf("%d",&arr[i]);
    }
    while(a!=7){
        if(arr[a]==arr[a+1]-1)
                a++;
        else break;
    }
     while(d!=7){
        if(arr[d]==arr[d+1]+1)
                d++;
        else break;
    }
	if(a+d<7)
		printf("mixed");
	else if(d==7)
		printf("descending");
	else if(a==7)
		printf("ascending");
	
}