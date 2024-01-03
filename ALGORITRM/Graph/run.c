#include <stdio.h>
int main() 
{
     int sum=0;
   for ( int i=1; i<=99; ){

     sum +=i;
     i+=2;
     if (sum==99)
     break;
   }
   printf("sum = %d\n",sum);
}