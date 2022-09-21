#include<stdio.h>
int main(){
    int tCase;
    int arr[1010] = {};
    int max[1010] = {0,};
    int tmp;
    
    scanf("%d",&tCase);
    
    for(int i = 1; i <= tCase; i++){
        scanf("%d",&arr[i]);
        for(int j = 0; j <= i; j++){
            tmp = max[j]+arr[i-j];
            if(max[i] < tmp)
                max[i] = tmp;
        }
    }
    
    printf("%d",max[tCase]);
}