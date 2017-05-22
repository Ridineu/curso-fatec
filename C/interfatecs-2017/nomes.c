#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX_NOME 20

int main(){
	
	char nomes[2][MAX_NOME];
	int q, i, j, f;
	
	scanf("%s %d", nomes[0], &q);
	
	for(i=0; i<q; i++){
		scanf("%s", nomes[1]);
		
		if(strlen(nomes[0]) < 4 || strlen(nomes[1]) < 4)
			f=1;
		else
			for(j=0, f=0; j<4 && !f; j++)
				if(nomes[0][j] != nomes[1][j])
					f++;
			
		if(f)
			printf("NORMAL\n");
		else
			printf("VERIFICAR\n");
	}
	
	return 0;
}