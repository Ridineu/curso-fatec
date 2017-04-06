#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define PARAR -999

typedef struct regNo{ struct regNo *esq; int valor; struct regNo *dir;}TNo;
typedef struct{TNo *raiz; int maior, menor, flag, altura;}TDes;

TNo *AchaPai( TNo *r, int n );
void ImprimeArvore(TNo *);
void IncluiNoh(TDes *, int);
void inicializa(TDes *);

void defineExtremos(TDes *, TNo *);
int contaFolhas(TNo *);
void alturaArvore(TDes *, TNo *, int);
int Pesquisa(TNo *, int);

int main(){ 
	
	int valor;
	TDes d;
		
	inicializa(&d);
	
	while(scanf("%d", &valor) && valor != PARAR)
		IncluiNoh(&d, valor);
		
	printf("Valor dos nohs (PreFixa):");
	ImprimeArvore(d.raiz);
	defineExtremos(&d, d.raiz);
	if(!d.flag)
		printf("\nArvore vazia, logo nao ha valor maior nem menor!\n");
	else
		printf("\nMaior valor da arvore: %d\nMenor valor da arvore: %d\n", d.maior, d.menor);
	printf("Quantidade de folhas: %d\n", contaFolhas(d.raiz));
	alturaArvore(&d, d.raiz, 0);
	printf("Altura da arvore: %d\n", d.altura);
	
	while(scanf("%d", &valor) && valor != PARAR)
		if(Pesquisa(d.raiz, valor))
			printf("%d existe na arvore\n", valor);
		else
			printf("%d nao existe na arvore\n", valor);
	
	return 0;
}

int Pesquisa(TNo *r, int valor){
	if(r == NULL)
		return 0;
	else
		if(r->valor == valor)
			return 1;
		else
			return Pesquisa(r->esq, valor) + Pesquisa(r->dir, valor);
}

void alturaArvore(TDes *d, TNo *r, int nivel){
	if(r != NULL){		
		alturaArvore(d, r->esq, nivel + 1);
		alturaArvore(d, r->dir, nivel + 1);
	}else
		if(nivel > d->altura)
				d->altura = nivel - 1;
	
}

int contaFolhas(TNo *r){
	if(r != NULL){
		if(r->esq == NULL && r->dir == NULL)
			return 1;
		else
			return contaFolhas(r->dir) + contaFolhas(r->esq);
	}else
		return 0;
}

void defineExtremos(TDes *d, TNo *r){
	if(r != NULL){
		if(!d->flag){
			d->maior = r->valor;
			d->menor = r->valor;
			d->flag = 1;
		}else{
			if(r->valor > d->maior)
				d->maior = r->valor;
			if(r->valor < d->menor)
				d->menor = r->valor;
		}
		defineExtremos(d, r->esq);
		defineExtremos(d, r->dir);
	}	
}

void ImprimeArvore(TNo *r){
	if( r != NULL ){	
		printf(" %d", r->valor);	
		ImprimeArvore(r->esq);		
		ImprimeArvore(r->dir);			
	}
}

void inicializa(TDes *d){
	d->raiz = NULL;
	d->flag = 0;
	d->altura = -1;
}

void IncluiNoh(TDes *d, int valor){
	TNo *aux, *pai;
	
	aux = (TNo *) malloc(sizeof(TNo));
	aux->valor = valor;
	aux->dir = NULL;
	aux->esq = NULL;	
	pai = AchaPai(d->raiz, valor);
	if(pai == NULL)
		d->raiz = aux;
	else
		if(valor <= pai->valor )
			pai->esq = aux;
		else
			pai->dir = aux;
}

TNo *AchaPai(TNo *r, int n){ 
	if( r == NULL )
		return NULL;
	else
		if( n <= r->valor )
	/* n é descendente do lado esquerdo de r */
			if( r->esq == NULL )
				return r;
			else
				return AchaPai( r->esq, n );
		else
	/* n é descendente do lado direito de r */
			if( r->dir == NULL )
				return r;
			else
				return AchaPai( r->dir, n );
}