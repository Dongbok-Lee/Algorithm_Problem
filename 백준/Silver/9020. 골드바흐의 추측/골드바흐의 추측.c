#include<stdio.h>
int main(){
    int tCase, num, i, j, l, cnt1=0, cnt2=0;
    scanf("%d",&tCase);
    for(i=0; i<tCase; i++){
        scanf("%d", &num);
        if(num==4){
            printf("2 2\n");
            scanf("%d",&num);
            i++;
        }
        for(j=0; j<=num/2; j++){
            for(l=2; l*l<=num; l++){
				if(((num/2)-j)%l==0){
					cnt1++;
				}
				if(((num/2)+j)%l==0){
					cnt2++;
				}
            }
        	if(cnt1==0&&cnt2==0){
            printf("%d %d\n",num/2-j ,num/2+j);
			break;
    		}
        cnt1=0;
        cnt2=0;
        }
        	
        }
}