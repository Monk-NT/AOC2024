#include <stdio.h>
#include <time.h>
#include <stdlib.h>


const char *languages[] = {"Haskell", "C/C++", "Java", "Kotlin", "Ruby", "Typescript (NodeJS)", "Python", "Rust"};

int main(void){

	srand(time(NULL));


	const char *language = languages[rand() % 8];

	printf("This Advent Of Code should be done using: %s", language);

	return 0;
}

