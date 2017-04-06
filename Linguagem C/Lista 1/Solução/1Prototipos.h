/*
	Autores: 	Ridineu de Moraes Neto 		0030481521033
				Rodrigo Ferreira Rodrigues  0030481521034
	
	Exercicio 1 da lista 1.
*/

struct regNoh{char RA[14], disc[6];
			float nota;
			int faltas;
			struct regNoh *next, *before;
			};
typedef struct regNoh tpNoh;
typedef struct{tpNoh *first; tpNoh *last; int qnt;}tpDesc;

void incluiNoh(tpDesc *, tpNoh);
int apagaNoh(tpDesc *, tpNoh);
void imprimiLista(tpDesc *, char*);
void start(tpDesc *);