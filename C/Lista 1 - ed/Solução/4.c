/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 4 da lista 1.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct regCarac{char carac; struct regCarac *next;};
typedef struct regCarac tCarac;
typedef struct{tCarac *topo;}tDes;

void push(tDes *, char);  
void pop(tDes *);
int compara(char, char);

int main(){	
	char in[21];
	int i, half, f;
	tDes d;
	while(scanf("%s", in) && strcmp(in,"FIM")){		
		d.topo = NULL;	
		i = strlen(in);
		half = i / 2;
		if(i % 2)
			f=1;
		else
			f=0;
		for(i=0;i<half;i++)
			push(&d, in[i]);		
		for(i=half+f;d.topo != NULL; i++){
			if(compara(in[i], d.topo->carac))
				pop(&d);
			else
				break;
		}				
		if(d.topo == NULL)
			printf("Palindromo.\n");
		else
			printf("Nao eh palindromo.\n");		
	}	
	return 0;
}

void push(tDes *d, char carac){	
	tCarac *aux = (tCarac *)malloc(sizeof(tCarac));
	aux->carac = carac;
	aux->next = d->topo;
	d->topo = aux;	
}

void pop(tDes *d){
	tCarac *aux = d->topo;
	d->topo = aux->next;
	free(aux);	
}

int compara(char a, char b){	
	if(a >= 65 && a <= 90)
		a += 32;
	if(b >= 65 && b <= 90)
		b += 32;	
	if(a != b){
		return 0;
	}else
		return 1;
}