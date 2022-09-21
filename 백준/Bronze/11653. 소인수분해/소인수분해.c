#include <stdio.h>

int main(void) {
	int num, cnt=0, i, j, w;
	scanf("%d",&num);
	w=num;
	if(num==1){
		printf(" ");
		return 0;
	}
	else{
		for(i=2; i*i<=num; i++){
			for(j=2; j*j<=i; j++){
				if(i==2){
				break;
			}else if(i%j==0){
				cnt++;
				break;
			}
			}
			if(cnt==0){
				while((w%i)==0){
					w=w/i;
					printf("%d\n",i);
					if(w==1){
						return 0;
					}
				}			
			}
			cnt=0;
		}
	}
	printf("%d",w);
}
