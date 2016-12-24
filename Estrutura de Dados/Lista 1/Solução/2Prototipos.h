/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 2 da lista 1.
*/

typedef struct { char RA[14], disc[6]; float nota; int faltas; } tpLista;
typedef struct { int inicio, final, qtde; } tpDesc;

void incluiNoh(tpDesc *, tpLista *, tpLista);
void imprimiLista(tpDesc *, tpLista *, char *);
int excluiNoh(tpDesc *, tpLista *, tpLista);
void inicializa(tpDesc *);