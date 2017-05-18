#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <math.h>

#define MAX 8
// t u v w x y z
// 0 1 2 3 4 5 6
int main(){
	
	int i;
	char vetor[MAX], in[MAX], flag=0;
	memset(vetor, 0, MAX);
	
	scanf("%s", in);

	for(i=0; in[i] > 32; i++)
		vetor[in[i] - 'T'] = 1;
		
	/*
	for(i=0; i<7; i++){
		printf("%c %d\n", 't' + i,  vetor[i]);
	}
	*/
				
	if(strlen(in) == 5 && vetor[3] != vetor[6] && ((vetor[5] && vetor[2]) || !vetor[5]) && !(vetor[1] && vetor[3]))	
		flag=1;
	else
		flag=0;
		
	if(flag)
		printf("VALIDA\n");
	else
		printf("INVALIDA\n");	
	
	return 0;
}
