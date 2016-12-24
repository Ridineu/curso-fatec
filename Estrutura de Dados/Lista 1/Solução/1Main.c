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

int main(){
	tpDesc d;
	tpNoh in;
	start(&d);
	
	while(1){		
		scanf("%s", in.RA);
		if(!strcmp(in.RA, "XXX"))
			break;
		scanf("%s %f %d", in.disc, &in.nota, &in.faltas);
		incluiNoh(&d, in);		
	}
	imprimiLista(&d, "Conteudo original:\n");
	while(1){
		scanf("%s", in.disc);
		if(!strcmp(in.disc, "XXX"))
			break;
		if(apagaNoh(&d, in))
			imprimiLista(&d, "\nNovo conteudo:\n");
		else
			printf("Sigla nao encontrada.\n");
	}
	
	return 0;
}
