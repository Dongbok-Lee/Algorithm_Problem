#include <stdio.h>
int main()
{
    int a,b=0;
    scanf("%d %d",&a, &b);
    if(a>0){
        if(b>0)
            printf("1");
        else if(b<0)
            printf("4");
    }
        if(a<0){
        if(b>0)
            printf("2");
        else if(b<0)
            printf("3");
    }
    return 0;
}

