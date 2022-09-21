#include<stdio.h>
int main(){
    long long num, arr[10]={0,}, i, j, k, sum=0, tmp;
    scanf("%lld",&num);
    if(num==1){
    	printf("10");
    	return 0;
    }
    for(i=0; i<10; i++){
        arr[i]=10-i;
    }
    for(i=2; i<num; i++){
        for(j=0; j<=9; j++){
        		tmp=arr[j];
        		arr[j]=0;
            for(k=9; k>=j+1; k--){
                arr[j]+=arr[k]%10007;
            }
            arr[j]+=tmp;
        }
    }
    for(i=0; i<=9; i++){
        sum+=arr[i];
    }
    printf("%lld",sum%10007);
}