#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main(){
    float tCase, x1, x2, y1, y2, R1, R2, r, i, temp;
    scanf("%f", &tCase);
    for(i=0; i<tCase; i++){
        scanf("%f %f %f %f %f %f",&x1, &y1, &R1, &x2, &y2, &R2);
        if(R1<R2){
        	temp=R2;
        	R2=R1;
        	R1=temp;
        }
        r=sqrt(fabs((x1-x2)*(x1-x2))+fabs((y1-y2)*(y1-y2)));
        if(r==0&&R1==R2){
            printf("-1\n");
        }else if(R1==r+R2||r==R1+R2){
            printf("1\n");
        }else if(R2+r<R1||r>R1+R2){
            printf("0\n");
        }else{
            printf("2\n");
        }
    }
}