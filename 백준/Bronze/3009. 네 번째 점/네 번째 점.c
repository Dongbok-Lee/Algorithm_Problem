#include<stdio.h>
int main(){
    int x[4], y[4], i;
    for(i=0; i<3; i++){
        scanf("%d %d",&x[i] ,&y[i]);
    }
    if(x[0]==x[1]){
        printf("%d ",x[2]);
    }else if(x[1]==x[2]){
        printf("%d ",x[0]);
    }else{
        printf("%d ",x[1]);
    }
    if(y[0]==y[1]){
        printf("%d ",y[2]);
    }else if(y[1]==y[2]){
        printf("%d ",y[0]);
    }else{
        printf("%d ",y[1]);
    }
}