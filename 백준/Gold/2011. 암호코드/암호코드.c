#include <stdio.h>
#define tmp 1000000

int main(void) {
	int pwd[5010] = {};
	int arr[5010] = {1, };
	int i = 1; 
	
	while(scanf("%1d", &pwd[i]) != EOF){
		if(pwd[i] > 0 && pwd[i] < 10)
			arr[i] += arr[i-1]%tmp;
		if(pwd[i-1]*10+pwd[i] >= 10 && pwd[i-1]*10+pwd[i] <= 26)
			arr[i] += arr[i-2]%tmp;
		else if(pwd[i] == 0)
			arr[i] == 0;
		i++;
	}
    
	printf("%d",arr[i-1]%tmp);
}
