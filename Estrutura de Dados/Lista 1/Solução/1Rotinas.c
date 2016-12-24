/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 1 da lista 1.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "1Interface.h"

int apagaNoh(tpDesc *d, tpNoh in){
	int qnt = d->qnt, f;
	tpNoh *aux = d->first;
	while(aux != NULL){
		if(!strcmp(in.disc, aux->disc)){
			if(aux == d->first){				
				d->first = d->first->next;
				if(d->first == NULL)
					d->last = NULL;
				else
					d->first->before = NULL;
				f=1;
			}
			if(aux == d->last){				
				d->last = d->last->before;
				d->last->next = NULL;
				f=1;
			}
			if(!f){
				aux->next->before = aux->before;
				aux->before->next = aux->next;
			}
			free(aux);
			d->qnt--;
		}
		aux = aux->next;	
	}
	if(qnt != d->qnt)
		return 1;
	else
		return 0;
}

void incluiNoh(tpDesc *d, tpNoh in){	
	tpNoh *aux;
	aux = (tpNoh *)malloc(sizeof(tpNoh));
	strcpy(aux->RA, in.RA);
	strcpy(aux->disc, in.disc);
	aux->nota = in.nota;
	aux->faltas = in.faltas;
	aux->next = NULL;
	if(d->first == NULL){
		aux->before = NULL;
		d->first = aux;
	}else{
		aux->before = d->last;
		d->last->next = aux;		
	}
	d->last = aux;
	d->qnt++;
}

void imprimiLista(tpDesc *d, char *texto){	
	tpNoh *aux = d->first;
	printf("%s", texto);
	if(aux == NULL)
		printf("Lista vazia.\n");
	else
		while(aux != NULL){
			printf("%13s %5s %5.2f %3d\n", aux->RA, aux->disc, aux->nota, aux->faltas);
			aux = aux->next;
		}		
}

void start(tpDesc *d){
	d->first = NULL;
	d->last = NULL;
	d->qnt = 0;
}