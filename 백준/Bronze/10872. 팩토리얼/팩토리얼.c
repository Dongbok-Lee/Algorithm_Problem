#include<stdio.h>
int factorial(int t,int s){
    if(t==0){
    	printf("%d",s);
        return 0;
    }
    s=s*t;
    t--;
    factorial(t,s);
    return s;
}
int main(){
    int num,sum=1;
    scanf("%d",&num);
    factorial(num,sum);
}
