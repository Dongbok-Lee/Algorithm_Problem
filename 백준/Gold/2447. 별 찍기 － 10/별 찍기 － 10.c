#include<stdio.h>
int repeat(int num, int k, char arr[2190][2190]){
    int i, j, l, m;
    if(k<3)
        return 0;
    repeat(num, k/3, arr);
    for(i=0; i<num/k; i++){
        for(j=0; j<num/k; j++){
            for(l=0; l<k/3 ; l++){
                for(m=0; m<k/3 ; m++){
                    arr[(k/3)+k*i+l][(k/3)+k*j+m]=' ';
              	}
            }
        }
    }
}
int main(){
    int num, i, j, k;
    char arr[2190][2190];
    scanf("%d",&num);
    k=num;
    for(i=0; i<num; i++){
        for(j=0; j<num; j++){
            arr[i][j]='*';
        }
    }
    repeat(num,k,arr);
    for(i=0; i<num; i++){
        for(j=0; j<num; j++){
            printf("%c",arr[i][j]);   
		}
		printf("\n");
    }
}