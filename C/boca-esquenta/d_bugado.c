#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <math.h>

int main(){
	
	int n, i, v;
	
	scanf("%d", &n);
	
	for(i=1, v=0; i<n; i++)
		if(n % i == 0)
			v+=i;
	
	if(v == n)
		printf("PERFEITO\n");
	else
		if(v > n)
			printf("ABUNDANTE\n");
		else
			printf("DEFICIENTE\n");
	
	return 0;
}