#include<stdio.h>
int main(){
    int num=1, i, j, dec = 0, cnt = 0;
    while(num!=0){
    scanf("%d",&num);
    if(num==0)
    break;
    for(i=num+1; i<=num*2; i++){
        for(j=2; j*j<=i; j++){
            if(i==2){
                break;
            }else if(i%j==0){
                cnt++;
                break;
            }
        }
        if(cnt==0){
            dec++;
        }
        cnt=0;
    }
        
    if(num==1){
    printf("1\n");
    }else{
    printf("%d\n",dec);
    }
    dec=0;
   }
}