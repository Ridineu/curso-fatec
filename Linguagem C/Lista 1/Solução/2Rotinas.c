/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 2 da lista 1.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "2Interface.h"


int excluiNoh(tpDesc *descritores, tpLista *Lista, tpLista in){
	int c = descritores->final, q = descritores->qtde;
	for(; c > -1; c--)
		if(!strcmp(in.disc, Lista[c].disc)){
			if(c == descritores->inicio && descritores->qtde == 1)
				descritores->inicio--;
			for(; c < descritores->final; c++)
				Lista[c] = Lista[c+1];
			descritores->final--;
			descritores->qtde--;
		}
	if(q != descritores->qtde)
		return 1;
	else
		return 0;
}

void imprimiLista(tpDesc *descritores, tpLista *Lista, char *str){
	int c;
	printf("%s", str);
	if (descritores->inicio == -1)
		printf("Lista vazia!\n");
	else
		for (c = 0; c < descritores->qtde; c++)
			printf("%13s %5s %5.2f %3d\n", Lista[c].RA, Lista[c].disc, Lista[c].nota, Lista[c].faltas);
}

void incluiNoh(tpDesc *descritores, tpLista *Lista, tpLista in){
	if(descritores->inicio == -1)
		descritores->inicio++;
	strcpy(Lista[++descritores->final].RA, in.RA);
	strcpy(Lista[descritores->final].disc, in.disc);
	Lista[descritores->final].nota = in.nota;
	Lista[descritores->final].faltas = in.faltas;
	descritores->qtde++;
}

void inicializa(tpDesc *descritores){
	descritores->inicio = -1;
	descritores->final = -1;
	descritores->qtde = 0;
}