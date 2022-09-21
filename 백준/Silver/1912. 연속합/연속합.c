#include<stdio.h>
int main(){
    int num;
    int arr[100006];
    int sum = 0;
    int max = -10000;
    
    scanf("%d",&num);
    for(int i = 1; i <= num; i++)
        scanf("%d",&arr[i]);
    
    for(int i = 1; i <= num; i++){
        sum+=arr[i];
        if(sum<0)
            sum=0;
        if(max<sum)
            max=sum;
    }
    if(max==0){
    	max=-1004;
    	for(int i=1; i<=num; i++){
    		if(max<arr[i]){
    			max=arr[i];
    		}
    	}
    }
    printf("%d",max);
}