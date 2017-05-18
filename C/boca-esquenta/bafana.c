#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main() {
	  
	int n, k, p;
	
	scanf("%d %d %d", &n, &k, &p);
	
	k += p % n;
	
	if(k > n)
		k -= n;
		
	printf("%d\n", k);	
	
	return 0;
}
