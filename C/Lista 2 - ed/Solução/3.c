#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Noh{struct Noh *esq, *dir; int valor;}TNo;
typedef struct{TNo *raiz;}TDes;

void insereNoh(TDes *, int);
TNo *achaPai(TNo *, int);
void inicializa(TDes *);

void notacaoTextual(TNo *);

int main(){ 	
	TDes d;
	int valor;
	
	inicializa(&d);
	
	while(scanf("%d", &valor) != EOF)
		insereNoh(&d, valor);
	
	notacaoTextual(d.raiz);
	printf("\n");
	
	return 0;
}

void notacaoTextual(TNo *r){
	printf("<");
	if(r == NULL)
		printf(" ");
	else{
		printf("%d", r->valor);
		notacaoTextual(r->esq);
		notacaoTextual(r->dir);
	}
	printf(">");
}

void inicializa(TDes *d){
	d->raiz = NULL;
}

void insereNoh(TDes *d, int valor){
	TNo *aux, *pai;
	aux = (TNo *)malloc(sizeof(TNo));
	aux->dir = NULL;
	aux->esq = NULL;
	aux->valor = valor;
	pai = achaPai(d->raiz, valor);
	if(pai == NULL)
		d->raiz = aux;		
	else
		if(valor <= pai->valor)
			pai->esq = aux;
		else
			pai->dir = aux;
}

TNo *achaPai(TNo *r, int valor){
	if(r == NULL)
		return NULL;
	else
		if(valor <= r->valor)
			if(r->esq == NULL)
				return r;
			else
				return achaPai(r->esq, valor);
		else
			if(r->dir == NULL)
				return r;
			else
				return achaPai(r->dir, valor);
}