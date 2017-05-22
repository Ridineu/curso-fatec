#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX_VAGAS 1000

typedef struct{int fatec, equipe, acertos, time, flag;}TParticipante;

int facul(const void *, const void *);
int equipe(const void *, const void *);
int compara(const void *, const void *);

int main(){
	
	TParticipante vetor[MAX_VAGAS];
	int v, f, q, i, j, l, aux[MAX_VAGAS], iaux, qt, k;
	
	scanf("%d %d %d", &v, &f, &q);
	
	for(i=0; i<q; i++){
		scanf("%d %d %d %d", &vetor[i].fatec, &vetor[i].equipe, &vetor[i].acertos, &vetor[i]. time);
		vetor[i].flag = 0;
	}
	
	qsort(vetor, q, sizeof(TParticipante), facul);
	
	for(qt=0, i=0, iaux=0; qt<f; qt++){
		l = vetor[i].fatec;
		for(j=i, k=0; l == vetor[j].fatec; j++){
			if(!k){
				aux[iaux++] = vetor[j].equipe;
				vetor[j].flag = 1;
				k=1;
			}			
		}
		i=j;
	}
	
	qsort(vetor, q, sizeof(TParticipante), equipe);
	
	/*
	for(i=0; i<q; i++)
		printf("%d %d %d %d %d\n", vetor[i].fatec, vetor[i].equipe, vetor[i].acertos, vetor[i].time, vetor[i].flag);
	
	printf("\n\n");
	*/
	
	for(i=0; iaux < v; i++)
		aux[iaux++] = vetor[i].equipe;
	
	qsort(aux, iaux, sizeof(int), compara);
	
	for(i=0; i<iaux-1; i++)
		printf("%d, ", aux[i]);
	printf("%d .\n", aux[iaux-1]);
	
	return 0;
}

int compara(const void *p1, const void *p2){
	int *i = (int *)p1, *j = (int *)p2;
	
	return(*i - *j);
}

int facul(const void *p1, const void *p2){
	TParticipante *i = (TParticipante *)p1, *j = (TParticipante *)p2;

		if(i->fatec > j->fatec)
			return 1;
		else
			if(i->fatec < j->fatec)
				return -1;
			else
				if(i->acertos > j->acertos)
					return -1;
				else
					if(i->acertos < j->acertos)
						return 1;
					else
						return (i->time - j->time);
}

int equipe(const void *p1, const void *p2){
	TParticipante *i = (TParticipante *)p1, *j = (TParticipante *)p2;
	
	if(i->flag > j->flag)
		return 1;
	else
		if(i->flag < j->flag)
			return 1;
		else
			if(i->acertos > j->acertos)
					return -1;
				else
					if(i->acertos < j->acertos)
						return 1;
					else
						return (i->time - j->time);
}


