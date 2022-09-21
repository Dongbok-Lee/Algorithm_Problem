#include<stdio.h>
int main(){
    int num;
    int minNum = 0;
    int maxNum = 0;
    int arr[1005]={};
    int max[1005]={};
    
    scanf("%d", &num);
    
    for(int i = 1; i <= num; i++)
        scanf("%d", &arr[i]);
    
    arr[0]=2000;
        
    for(int i = 1; i <= num; i++){
        minNum=0;
        for(int j = 1; j < i; j++){
            if(arr[i]<arr[j])
                if(max[j]>minNum)
                    minNum = max[j];
        }
        max[i] = minNum+1;
        if(maxNum<max[i])
        	maxNum=max[i];
    }
    
    printf("%d\n",maxNum);
}