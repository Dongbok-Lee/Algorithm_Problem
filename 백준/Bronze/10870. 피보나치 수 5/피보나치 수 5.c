#include<stdio.h>

int main(){
    int num, a=0, b=1;
    scanf("%d",&num);
    if(num==0){
    	printf("0");
    	return 0;
    }else if(num==1){
    	printf("1");
        return 0;
    }
    num-=2;
    sum(num,a,b);
}
int sum(int t,int u,int v){
	int s = 0;
    s=u+v;
    u=v;
    v=s;
    if(t==0){
        printf("%d",v);
        return 0;
    }
    t--;
    sum(t,u,v);
    }