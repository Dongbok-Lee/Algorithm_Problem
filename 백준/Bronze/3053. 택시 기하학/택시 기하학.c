#include <stdio.h>
int main(void) {
 double num;
 scanf("%lf",&num);
 printf("%.6lf\n", num*num*3.141592653589);
 printf("%.6lf", num*num*2);
 return 0;
}
