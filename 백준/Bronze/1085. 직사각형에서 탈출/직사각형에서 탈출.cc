#include<stdio.h>
int main(){
    int w ,h ,x ,y ,min=0;
    scanf("%d %d %d %d", &x, &y, &w, &h);
    min=w-x;
    if(min>x)
        min=x;
    if(min>h-y)
        min=h-y;
    if(min>y)
        min=y;
    printf("%d", min);
}