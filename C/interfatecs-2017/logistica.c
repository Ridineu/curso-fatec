#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX_PALLET 8
#define MAX_CONTAINERS 50

typedef struct{int tam, ipallet, pallets[MAX_PALLET];}TConteiner;

int main (){	
	
	TConteiner vetor[MAX_CONTAINERS];
	char c;
	int i, j, ip=1, p, acho;
	
	for(i=0; i<MAX_CONTAINERS; i++){
		vetor[i].tam = MAX_PALLET;
		vetor[i].ipallet = 0;
	}
	
	while(scanf("%d%c", &p, &c)){
		
		for(i=0; ;i++)
			if(vetor[i].tam >= p){
				vetor[i].tam -=p;
				vetor[i].pallets[vetor[i].ipallet++] = ip++;
				break;
			}		
		if(c != ' ')
			break;
	}
	
	/*
	for(i=0; i<4; i++){
		printf("conteiner %d: ", i+1);
		for(j=0; j<vetor[i].ipallet;j++)
			printf("%d ",vetor[i].pallets[j]);
		printf("\n");
	}
	*/

	while(scanf("%d", &p) != EOF)
		for(i=0, acho=0; acho==0; i++)
			for(j=0; j < vetor[i].ipallet; j++)
				if(vetor[i].pallets[j] == p){
					acho=1;
					
					printf("Pallet %d Container %d ", p, i+1);
					
					if(vetor[i].pallets[vetor[i].ipallet-1] == p)
						printf("TOPO\n");
					else{
						printf("Retirar");
						
						for(j=vetor[i].ipallet-1; vetor[i].pallets[j] != p; j--)
							printf(" %d", vetor[i].pallets[j]);
						printf("\n");
						j=MAX_PALLET+1;
					}
				}
	
	return 0;
}
