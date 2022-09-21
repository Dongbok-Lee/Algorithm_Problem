#include<stdio.h>
int main ()
{
    float a,b,c,g,j,k=0;
	 	int d,e,f=0;
	
    scanf("%f %f",&a,&b);
	  c=b/100;
	  d=(int)c*(int)a;
		g=(b-((int)c*100))/10;
	  e=(int)g*(int)a;
		f=(b-((int)c*100)-((int)g*10))*(int)a;
		printf("%d\n",f);
		printf("%d\n",e);
    printf("%d\n",d);
		printf("%ld",(long)a*(long)b);
    return 0;
    
}