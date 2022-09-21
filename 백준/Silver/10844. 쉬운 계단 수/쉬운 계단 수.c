#include<stdio.h>
int main(){
    long long num ,i, j, arr[105][11]={0,}, ans=0;
    scanf("%lld",&num);
    if(num==1){
    	printf("9");
    	return 0;
    }
    for(i=0; i<10; i++){
        arr[2][i]=1;
        if(i>=2&&i<9)
            arr[2][i]++;
    }
    for(i=3; i<=num; i++){
        for(j=0; j<10; j++){
            if(j==0){
                arr[i][j]=arr[i-1][j+1]% 1000000000;    
            }else if(j==9){
                arr[i][j]=arr[i-1][j-1]% 1000000000;
            }else{
            	arr[i][j]=arr[i-1][j-1]+arr[i-1][j+1]% 1000000000;
            }
        }
	}
	for(i=0; i<=9; i++) {
		ans=(ans+arr[num][i]) % 1000000000;
	}
    printf("%lld",ans);
}