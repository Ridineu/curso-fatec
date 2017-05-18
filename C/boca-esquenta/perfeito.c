#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main() {
	  
	int j=0, i, n;
	
	scanf("%d", &n);
	
	for(i=1; i<n; i++)
		if(n % i == 0)
			j+=i;	
	
	if(n > j)
		printf("DEFICIENTE\n");
	else
    	if(n == j)
			printf("PERFEITO\n");
		else
			printf("ABUNDANTE\n");
	
	return 0;
}
