#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

#define MAX_COLUNA 9
#define MAX_LINHA 9
#define MAX_JOGADOR 100
#define MAX_BOLAS 100
#define DESENHO 0

typedef struct{int vetor[MAX_BOLAS], index, turno;}TEstrutura;

int main(){
	
	TEstrutura winners, bolas;
	int cartelas[MAX_JOGADOR][MAX_LINHA][MAX_COLUNA], il, ic, ik;
	int i, j, k, v, r, f, e, bingo;	
	scanf("%d %d %d", &il, &ic, &ik);
	
	for(k=0; k<ik; k++)
		for(i=0; i<il; i++)
			for(j=0; j<ic; j++)
				scanf("%d", &cartelas[k][i][j]);
				
	/*		
	for(k=0; k<ik; k++){
		printf("%da cartela\n", k+1);
		for(i=0; i<il; i++){
			for(j=0; j<ic; j++)	
				printf("%d ", cartelas[k][i][j]);
			printf("\n");
		}
		printf("\n");
	}
    */
	
	scanf("%d", &v);
	
	for(r=0, bolas.index=0; r<v; r++)
		scanf("%d", &bolas.vetor[bolas.index++]);
	
	for(r=0, winners.index=0; r<bolas.index && !winners.index; r++){
		for(k=0, f=0; k<ik; k++)
			for(i=0; i<il; i++)
				for(j=0; j<ic; j++)
					if(cartelas[k][i][j] == bolas.vetor[r]){
						cartelas[k][i][j] = DESENHO;
						f=1;
					}
	
		for(k=0; f && k<ik && winners.index < 2; k++){
		
			//linhas
			for(i=0, e=0, bingo=0; i<il && !bingo; i++, e=0){
				for(j=0; j<ic && !e; j++)	
					if(cartelas[k][i][j] != DESENHO)
						e++;
				bingo = !e;		
			}
					
			//colunas		
			for(i=0, e=0; i<ic && !bingo; i++, e=0){
				for(j=0; j<il && !e; j++)
					if(cartelas[k][i][j] != DESENHO)
						e++;
				bingo = !e;	
			}	
							
			if(bingo){
				winners.vetor[winners.index++] = k+1;
				winners.turno = r+1;
			}							
		}						
	}
	
	if(!winners.index)
		printf("NADA\n");
	else
		if(winners.index > 1)
			printf("EMPATE\n");
		else
			printf("%d %d\n", winners.vetor[0], winners.turno);
	
	return 0;
}


