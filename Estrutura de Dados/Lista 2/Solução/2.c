#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define PARAR -999

typedef struct Noh{struct Noh *esq, *dir; int valor;}TNo;
typedef struct{TNo *raiz;}TDes;

void insereNoh(TDes *, int, int);
TNo *achaPai(TNo *, int);
void inicializa(TDes *);

int equivalentes(TNo *, TNo *);

int main(){ 	
	TDes d[2];
	int i, valor;
	
	inicializa(d);
	
	for(i=0; i<2; i++)
		while(scanf("%d", &valor) && valor != PARAR)
			insereNoh(d, i, valor);
		
	if(!equivalentes(d[0].raiz, d[1].raiz))
		printf("Arvores equivalentes\n");
	else
		printf("Arvores nao sao equivalentes\n");
	
	return 0;
}

int equivalentes(TNo *a1, TNo *a2){
	if((a1 != NULL && a2 == NULL) || (a1 == NULL && a2 != NULL))
		return 1;
	else
		if(a1 == NULL && a2 == NULL)
			return 0;
		else
			if(a1->valor == a2->valor)
				return equivalentes(a1->esq, a2->esq) + equivalentes(a1->dir, a2->dir);
			else
				return 1;
}

void inicializa(TDes *d){
	int i;
	for(i=0; i<2; i++)
		d[i].raiz = NULL;
}

void insereNoh(TDes *d, int ind, int valor){
	TNo *aux, *pai;
	aux = (TNo *)malloc(sizeof(TNo));
	aux->dir = NULL;
	aux->esq = NULL;
	aux->valor = valor;
	pai = achaPai(d[ind].raiz, valor);
	if(pai == NULL)
		d[ind].raiz = aux;		
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