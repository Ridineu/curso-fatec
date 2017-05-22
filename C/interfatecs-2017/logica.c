#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main (){
	unsigned long long int n;
	
	scanf("%llu",&n);
	
	if((n%3)==0)
		printf("par\n");	
	else
		printf("impar\n");
	
	return 0;
}
