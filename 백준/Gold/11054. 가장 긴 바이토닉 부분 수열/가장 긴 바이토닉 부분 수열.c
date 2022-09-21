#include<stdio.h>
int main(){
    int num;
    int arr[1005] = {};
    int dec[1005] = {};
    int inc[1005] = {};
    int sum[1005] = {};
    int maxNum = 0;
    int temp = 0;
    
    scanf("%d", &num);
    for(int i = 1; i <= num; i++)
        scanf("%d", &arr[i]);
    
    for(int i = num; i >= 1; i--){
        temp = 0;
        for(int j = num+1; j > i; j--){
            if(arr[i] > arr[j])
                if(temp<dec[j])
                    temp=dec[j];       
        }
        dec[i]=temp+1;
    }
    
    for(int i = 1; i <= num; i++){
        temp = 0;
        for(int j = 0; j < i; j++){
            if(arr[i] > arr[j])
                if(temp<inc[j])
                    temp = inc[j];       
        }
        inc[i]=temp+1;
        if(inc[i]+dec[i]>maxNum)
            maxNum=inc[i]+dec[i];
             
       }
    printf("%d",maxNum-1);
}