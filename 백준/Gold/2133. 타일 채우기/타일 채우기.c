#include<stdio.h>
int main(){
    int num;
    long long arr[32] = {};
    
    scanf("%d", &num);
    
    if(num%2 == 1){
        printf("0");
        return 0;
    }
    
    arr[2]=3;
    for(int i = 2; i <= num/2; i++){
        arr[i*2]=arr[(i-1)*2]*3+2;
        for(int j = 4; j < i*2; j=j+2){
            arr[i*2]=arr[i*2]+arr[(i*2)-j]*2;
        }
    }
    printf("%d",arr[num]);
}