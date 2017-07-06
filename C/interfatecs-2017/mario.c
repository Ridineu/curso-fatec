#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define TRUE  1
#define FALSE 0

#define JAFOI  'F'
#define INICIO 'S'
#define FIM    'T'
#define OBST   'x'

#define MAX     1000
#define MAXFILA 10000000

typedef struct{short int x, y, movimento;}TCelula;

char mapa[MAX][MAX+1], teste[MAX][MAX];
TCelula fila[MAX * MAX];

char bfs(TCelula, short int, short int, short int);
char posicaoValida(char);

int f;

int main(){
	
	short int n, m, i, j, vidas;
	TCelula partida;
	
	scanf("%hd %hd", &n, &m);
	
	for(i=0; i<n; i++)
		scanf("%s", mapa[i]);
	
	scanf("%hd", &vidas);
		
	for(i=0; i<n; i++)
		for(j=0; j<m; j++)
			if(mapa[i][j] == INICIO){
				partida.x = i;
				partida.y = j;
				partida.movimento = 0;
				break;
			}
	
	printf("%d %d", partida.x, partida.y); 
	
	if(bfs(partida, n, m, vidas * 4))
		printf("SIM\n");
	else
		printf("NAO\n");
	
	/*
	memset(teste, -1, sizeof(teste));
	
	for(i=0; i<f; i++)
		teste[fila[i].x][fila[i].y] = fila[i].movimento;
		
	for(i=0; i<n; i++){
		for(j=0; j<m; j++)
			printf("%02d ", teste[i][j]);
		printf("\n");
	}
	
	*/
	
	return 0;
}

char bfs(TCelula partida, short int n, short int m, short int vidas){
	short int i=0;
	TCelula vez;
	f=0;
	fila[f++] = partida;	
	
	while (f != i){	
	
		vez = fila[i++];
				
		if(mapa[vez.x][vez.y] == FIM)
			return TRUE;
		
		mapa[vez.x][vez.y] = JAFOI;	
		
		/*
		int j;
		for(j=0; j<n; j++){
			printf("%s\n", mapa[j]);
		}
		printf("\n\n");
		*/
		
		vez.movimento += 1;
		if(vez.movimento <= vidas){
						
			vez.x++;
			if(vez.x < n && posicaoValida(mapa[vez.x][vez.y]))								
				fila[f++] = vez;
			vez.x--;
			
			vez.x--;
			if(vez.x >= 0 && posicaoValida(mapa[vez.x][vez.y]))								
				fila[f++] = vez;
			vez.x++;
			
			vez.y++;
			if(vez.y < m && posicaoValida(mapa[vez.x][vez.y]))								
				fila[f++] = vez;
			vez.y--; 			
			
			vez.y--; 	
			if(vez.y >= 0 && posicaoValida(mapa[vez.x][vez.y]))											
				fila[f++] = vez;
			vez.y++;			
		}		
		
	}
	
	return FALSE;	
}

char posicaoValida(char posicao){
	if(posicao != JAFOI && posicao != OBST)
		return TRUE;
	return FALSE;
}
