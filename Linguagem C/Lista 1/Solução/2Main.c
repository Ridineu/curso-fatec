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

int main(){
	tpLista lista[100], in;
	tpDesc descritores;
	
	inicializa(&descritores);	
	while (1){
		scanf("%s", in.RA);		
		if (strcmp(in.RA, "XXX") == 0)
			break;
		scanf("%s %f %d", in.disc, &in.nota, &in.faltas);
		incluiNoh(&descritores, lista, in);
	}
	imprimiLista(&descritores, lista, "Conteudo original:\n");	
	while(1){
		scanf("%s", in.disc);		
		if (strcmp(in.disc, "XXX") == 0)
			break;
		if(!excluiNoh(&descritores, lista, in))
			printf("Sigla nao encontrada.\n");
		else
			imprimiLista(&descritores, lista, "Novo conteudo:\n");		
	}
	
	return 0;
}