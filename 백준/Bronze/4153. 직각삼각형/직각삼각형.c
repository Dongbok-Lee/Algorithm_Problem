#include<stdio.h>
int main(){
    int x=0, y=0, z=1, a, b, c;
    while(x+y+z!=0){
    scanf("%d %d %d",&x ,&y ,&z);
    if(x+y+z==0){
        return 0;
    }
    if(x<y&&z<y){
        a=x;
        b=z;
        c=y;
    }else if(y<x&&z<x){
        a=y;
        b=z;
        c=x;
    }else{
        a=x;
        b=y;
        c=z;
    }
        if((a*a)+(b*b)==c*c){
        printf("right\n");
    }else{
        printf("wrong\n");
    }
}
}