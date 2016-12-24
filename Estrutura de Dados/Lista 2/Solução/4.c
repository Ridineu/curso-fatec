#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define PARAR -999

typedef struct Noh{struct Noh *esq, *dir, *pai; int valor;}TNo;
typedef struct{TNo *raiz;}TDes;

void insereNoh(TDes *, int);
TNo *achaPai(TNo *, int);

void RemoveNoh(TNo *, int);
TNo *maiorEsq(TNo *);
int gamb, foi; 

int Pesquisa(TNo *, int);
TNo *p;

void pref(TNo *);

int main(){
	TDes d;
	int valor;
	d.raiz = NULL;
	
	while(scanf("%d", &valor) && valor != PARAR)
		insereNoh(&d, valor);
	
	printf("Conteudo da arvore (PreFixa):");
	pref(d.raiz);
	printf("\n");
	while(scanf("%d", &valor) && valor != PARAR){
		foi = gamb = 0;
		RemoveNoh(d.raiz, valor);
		if(gamb)
				d.raiz = NULL;
		if(foi){
			printf("Conteudo da arvore (PreFixa):");
			pref(d.raiz);
			printf("\n");
		}else
			printf("Impossivel excluir %d, pois este valor nao existe na arvore!\n", valor);
	}
			
	return 0;
}

void RemoveNoh(TNo *r, int valor){
	TNo *aux;
	p=NULL;
	if(Pesquisa(r, valor)){
		foi=1;
		if(p->esq == NULL && p->dir == NULL){
			if(p->pai != NULL)
				if(p->pai->esq == p)
					p->pai->esq = NULL;
				else
					p->pai->dir = NULL;
			else
				gamb++;
		}else{
			if(p->esq == NULL || p->dir == NULL){
				if(p->esq != NULL)
					aux = p->esq;
				else
					aux = p->dir;
				p->dir = aux->dir;
				if(p->dir != NULL)
					p->dir->pai = p;
				p->esq = aux->esq;
				if(p->esq != NULL)
					p->esq->pai = p;
				p->valor = aux->valor;
			}else{
				aux = maiorEsq(p->esq);
				p->valor = aux->valor;
				RemoveNoh(aux, aux->valor);
			}
		}
	}
}

TNo *maiorEsq(TNo *r){
	if(r->dir == NULL)
		return r;
	else
		return maiorEsq(r->dir);
}

int Pesquisa(TNo *r, int valor){
	if(r == NULL)
		return 0;
	else
		if(r->valor == valor){
			if(p == NULL)				
				p = r;			
			return 1;
		}else
			return Pesquisa(r->esq, valor) + Pesquisa(r->dir, valor);
}

void insereNoh(TDes *d, int valor){
	TNo *aux, *pai;
	aux = (TNo *)malloc(sizeof(TNo));
	aux->dir = NULL;
	aux->esq = NULL;
	aux->valor = valor;
	pai = achaPai(d->raiz, valor);
	aux->pai = pai;
	if(pai == NULL){
		d->raiz = aux;		
	}else
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

void pref(TNo *r){
	if(r != NULL){
		printf(" %d", r->valor);
		pref(r->esq);
		pref(r->dir);
	}
}