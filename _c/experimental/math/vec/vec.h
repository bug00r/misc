#if 0
/**
	This ist the main vec api header file and should be used in the project.
	Sure you can use vec2/3.ha directly but then you can't use the prepared
	config switches
*/
#endif

#ifndef VEC_H
#define VEC_H

#include <stdio.h>

#define C_VEC_DEC(type, typeshort,count) \
	typedef struct { \
		type _v[count]; \
	} vec##count####typeshort##_t; \
					\
	void print_vec##count####typeshort(vec##count####typeshort##_t * vec); \

C_VEC_DEC(int, i,3)
C_VEC_DEC(int, i,2)
C_VEC_DEC(int, i,1)
C_VEC_DEC(float, f,3)
C_VEC_DEC(float, f,2)
C_VEC_DEC(float, f,1)

#undef C_VEC_DEC

#endif