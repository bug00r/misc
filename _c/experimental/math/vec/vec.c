#include "vec.h"

#define C_VEC_DEF(type, count) \
									   \
	void print_vec##count####type(vec##count####type##_t * vec) \
	{ \
	  printf("dummy print for vec" #count #type "_t\n");\
	} \

C_VEC_DEF(i, 3)
C_VEC_DEF(i, 2)
C_VEC_DEF(i, 1)
C_VEC_DEF(f, 3)
C_VEC_DEF(f, 2)
C_VEC_DEF(f, 1)

#undef C_VEC_DEF

