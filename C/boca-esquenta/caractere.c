#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <math.h>

#define MAX_INPUT 1050
#define MAX_ALF 26

typedef struct{int ordem, qnt; char ascii;}TLetra; 
int compara(const void *, const void *);

int main(){
	
	int i, j;	
	char in[MAX_INPUT];	
	TLetra vetor[MAX_ALF];
	memset(vetor, 0, sizeof(TLetra) * MAX_ALF);
	
	fgets(in, MAX_INPUT, stdin);
	
	for(i=0, j=1; in[i] >= 32; i++){
		if(in[i] >= 'A' && in[i] <= 'Z')
			in[i] += 32;
		if(in[i] != ' '){
			if(!vetor[in[i] - 'a'].qnt){
				vetor[in[i] - 'a'].ordem = j++;
				vetor[in[i] - 'a'].ascii = in[i];
			}
			vetor[in[i] - 'a'].qnt++;	
		}
	}
	
	qsort(vetor, MAX_ALF, sizeof(TLetra), compara);
	
	printf("%c %d\n", vetor[0].ascii, vetor[0].qnt);
	return 0;
}

int compara(const void *p1, const void *p2){
	TLetra *i = (TLetra *)p1, *j = (TLetra *)p2;
	
	if(i->qnt > j->qnt)
		return -1;
	else
		if(i->qnt < j->qnt)
			return 1;
		else
			return (i->ordem - j->ordem);
}
