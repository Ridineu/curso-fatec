/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 3 da lista 1.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct regNo{float num;struct regNo *next;};
typedef struct regNo tpNo;
typedef struct{tpNo *first; tpNo *last;}tpDe;

void incluiNoh(tpDe *, int, float);
void imprimiLista(tpDe *, int);
void somaNoh(tpDe *);
void start(tpDe *);

int main(){	
	int i;
	float num;
	tpDe d[3];
	start(d);
	
	for(i=0;i<2;i++)
		while(scanf("%f", &num) && num >= 0)
			incluiNoh(d, i, num);
	for(i=0;i<2;i++)
		imprimiLista(d, i);
	somaNoh(d);
	imprimiLista(d, 2);
	return 0;
}

void somaNoh(tpDe *d){
	int i;
	float valor;
	tpNo *aux[2];	
	for(i=0;i<2;i++)
		aux[i] = d[i].first;
	
	while(aux[0] != NULL || aux[1] != NULL){
		if(aux[0] != NULL && aux[1] != NULL){
			valor = aux[0]->num + aux[1]->num;
			aux[0] = aux[0]->next;
			aux[1] = aux[1]->next;
		}else
			if(aux[0] != NULL){
				valor = aux[0]->num;
				aux[0] = aux[0]->next;
			}else{
				valor = aux[1]->num;
				aux[1] = aux[1]->next;
			}		
		incluiNoh(d, 2, valor);	
	}
}

void incluiNoh(tpDe *d, int ind, float n){
	tpNo *aux = (tpNo *)malloc(sizeof(tpNo));
	aux->num = n;
	aux->next = NULL;
	if(d[ind].first == NULL)
		d[ind].first = aux;
	else
		d[ind].last->next = aux;
	d[ind].last = aux;
}

void imprimiLista(tpDe *d, int ind){
	tpNo *aux = d[ind].first;
	printf("Lista %d:", ind+1);
	while(aux != NULL){		
		printf(" %-5.2f", aux->num);
		aux = aux->next;
	}
	printf("\n");
}

void start(tpDe *d){
	int i;
	for(i=0;i<3;i++){
		d[i].first = NULL;
		d[i].last = NULL;
	}
}