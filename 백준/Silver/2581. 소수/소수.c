#include <stdio.h>

int main(void) {
	int i, j, sum = 0, cnt = 0, min = 100000, x, y;
	scanf("%d %d", &x, &y);{
		for(i=x; i<=y; i++){
			if(i==1){
				cnt++;
			}
			for(j=2; j*j<=i; j++){
				 if(i == 2){
					break;
				}else if(i%j==0){
					cnt++;
					break;
				}
			}
			if(cnt==0){
				if(min>i){
					min=i;
				}
				sum+=i;
			}
			cnt=0;
		}
	}
	if(sum==0){
		printf("-1");
	}else{
	printf("%d\n%d",sum, min);
	}
	return 0;
}
