#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

int main(){
	int n, i, j=1, v, p, q, last;
	
	scanf("%d", &n);
	q = pow(n, 3);
		
	do{
		for(i=j, v=0, p=0; p<n; p++, i+=2)
			v+=i;				
		last = i;
		j+=2;	
	}while(v != q);
		
	printf("%d\n", last-2);

	return 0;
}
