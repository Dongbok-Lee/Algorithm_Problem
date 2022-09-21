#include<stdio.h>
int main(){
    int i, j, num, arr[1005] = {}, temp[1005] = {}, Max = 0, Min = 0;
    scanf("%d",&num);
    for(i=1; i <=num ; i++)
        scanf("%d",&arr[i]);
    for(i=1; i<=num; i++){
        Min = 0;
        for(j=0; j<i; j++){
            if(arr[i]>arr[j]){
                if(Min<temp[j])
                    Min = temp[j];
            }
        }
        temp[i] = Min+1;
        if(temp[i]>Max)
            Max = temp[i];
    }
    printf("%d",Max);
}