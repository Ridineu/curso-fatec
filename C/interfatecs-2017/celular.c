#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX 210

int main(){
	
	char in[MAX], c;
	int i, v;
	
	fgets(in, MAX, stdin);
	
	for(i=0, v=0; in[i] >= 32; i++){
		c = in[i];
		
		if(c == 'a' || c == 'd' || c == 'g' || c == 'j' || c == 'm' || c == 'p' || c == 't' || c == 'w' || c == ' ')
			v++;
		else if(c == 'b' || c == 'e' || c == 'h' || c == 'k' || c == 'n' || c == 'q' || c == 'u' || c == 'x')
			v+=2;
		else if(c == 'c' || c == 'f' || c == 'i' || c == 'l' || c == 'o' || c == 'r' || c == 'v' || c == 'y')
			v+=3;
		else if(c == 'a'-32 || c == 'd'-32 || c == 'g'-32 || c == 'j'-32 || c == 'm'-32 || c == 's' || c == 't'-32 || c == 'z')
			v+=4;
		else if(c == 'b'-32 || c == 'e'-32 || c == 'h'-32 || c == 'k'-32 || c == 'n'-32 || c == 'p'-32 || c == 'u'-32 || c == 'w'-32)
			v+=5;
		else if(c == 'c'-32 || c == 'f'-32 || c == 'i'-32 || c == 'l'-32 || c == 'o'-32 || c == 'q'-32 || c == 'v'-32 || c == 'x'-32)
			v+=6;
		else if(c == 'R' || c == 'Y')
			v+=7;
		else
			v+=8;
	}
	
	printf("%d\n", v);
	
	return 0;
}



