#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX 9

int main(){
	
	char in[MAX];
	int i, j, v;

	scanf("%s", in);
	
	for(i=5, j=2, v=0; i >= 0; i--, j++)
		v+= (in[i] - '0') * j;	
	v = (11 - (v % 11));
	
	if(((v == 10 || v == 11) && in[7] == '0') || (in[7] - '0' == v))
		printf("CORRETO\n");
	else
		printf("INCORRETO\n");
	
	return 0;
}