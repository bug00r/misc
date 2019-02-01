#include "vec.h"

#include <stdio.h>

int 
main(int argc, char *argv[]) 
{
	printf(">> experimental vector test\n");
	
	vec3i_t v3;
	vec2i_t v2;
	vec1i_t v1;
	vec3f_t v4;
	vec2f_t v5;
	vec1f_t v6;
	
	print_vec3i(&v3);
	print_vec2i(&v2);
	print_vec1i(&v1);
	
	print_vec3f(&v4);
	print_vec2f(&v5);
	print_vec1f(&v6);
	
	printf("<< experimental vector test\n");
	return 0;
}