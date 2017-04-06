/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 5 da lista 1.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct regNoh{int coef; int exp; struct regNoh *next;};
typedef struct regNoh tNoh;
typedef struct{tNoh *first;tNoh *last;}tDes;

void inicializa(tDes *);
void incluiNoh(tDes *, char *, int);
int calcula(tDes *, int);

int main(){		
	int n, i, j=0, vl, v, qnt;
	char in[31], noh[30];
	tDes d;
	
	scanf("%d", &n);	
	while(j < n){
		scanf("%s", in);
		inicializa(&d);
		for(i=0, qnt=0;in[i] != '\0';i++){
			if(qnt && (in[i] == '+' || in[i] == '-' || in[i+1] == '\0')){
				if(in[i+1] == '\0')
					noh[qnt++] = in[i];
				incluiNoh(&d, noh, qnt);
				qnt=1;
				noh[qnt-1] = in[i];
			}else
				noh[qnt++] = in[i];					
		}
		scanf("%d", &v);
		printf("Caso %d:", ++j);
		for(i=0;i<v;i++){
			scanf("%d", &vl);
			printf(" %d", calcula(&d, vl));
		}
		printf("\n");
	}	
	return 0;
}

int calcula(tDes *d, int v){
	int ret=0;
	tNoh *aux = d->first;
	while(aux != NULL){
		ret+= aux->coef * pow(v,aux->exp);
		aux= aux->next;
	}
	return ret;
}

void incluiNoh(tDes *d, char *noh, int qnt){
	int i, j, sinal=1, coef=0, mult, exp=0;	
	tNoh *aux = (tNoh *)malloc(sizeof(tNoh));
	if(noh[0] == '-')
		sinal = -1;
	for(i=0;i<qnt;i++)
		if(noh[i] == 'x')
			break;
	for(j=i-1, mult=1; j >= 0 && noh[j] != '+' && noh[j] != '-'; j--){
		coef += (noh[j] - '0') * mult;
		mult *= 10;
	}
	for(j=qnt-1, mult=1;j > i; j--){
		exp+= (noh[j] - '0') * mult;
		mult *= 10;
	}
	aux->coef = coef * sinal;
	if(i != qnt){
		if(!coef)
			aux->coef = 1;		
		if(!exp)
			aux->exp = 1;
		else
			aux->exp = exp;
	}else
		aux->exp = 0;
	aux->next = NULL;
	if(d->first == NULL)
		d->first = aux;
	else
		d->last->next = aux;
	d->last = aux;
}

void inicializa(tDes *d){
	d->first = NULL;
	d->last = NULL;
}
