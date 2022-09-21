#include <stdio.h>

int main(void) {
	char arr1[10005], arr2[10005], sum[10005]={0};
	int i,j,a=0,b=0,l,s;
	scanf("%s %s" ,&arr1[1],&arr2[1]);
	for(i=1; i<10005; i++){
		if(arr1[i]<=57&&arr1[i]>=48){
			a=i;
		}
		else
			break;
	}
	for(i=1; i<10005; i++){
		if(arr2[i]<=57&&arr2[i]>=48){
			b=i;
		}
		else
		break;
	}
	if(a<b){
		l=b;
		s=a;
		for(i=1; i<=l-s; i++){
			sum[i]=arr2[i]-48;
		}
		for(i=0; i<s; i++){
		sum[l-i]=(arr1[a-i]+arr2[b-i]-96);
	}
	}else{
		l=a;
		s=b;
		for(i=1; i<=l-s; i++){
			sum[i]=arr1[i]-48;
		}
		for(i=0; i<s; i++){
		sum[l-i]=(arr1[a-i]+arr2[b-i]-96);
	}
	}
	for(i=l; i>0; i--){
		if(sum[i]>=10){
				sum[i]=sum[i]%10;
				sum[i-1]+=1;

		}
	}
	if(sum[0]==1){
		for(i=0; i<=l; i++){
			printf("%d",sum[i]);
		}
	}else{
			for(i=1; i<=l; i++){
			printf("%d",sum[i]);
	}
	return 0;
}
}