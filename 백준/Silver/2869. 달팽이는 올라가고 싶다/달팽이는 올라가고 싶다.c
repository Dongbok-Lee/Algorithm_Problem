#include <stdio.h>

int main(void) {
	int a,b,v,i,length=0;
	scanf("%d %d %d",&a,&b,&v);
	if(v==a){
	printf("1");
	}else if((v-a)%(a-b)==0){
	printf("%d",(v-a)/(a-b)+1);
}else{
	printf("%d",(v-a)/(a-b)+2);
}
}
