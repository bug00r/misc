from libc.stdlib cimport free, srand
from libc.time cimport time
from libcpp cimport bool

cdef extern from "utils_math.h":
	float interpolate_lin(const float x, const float x0, const float f0, const float x1, const float f1)
	

cdef extern from "average.h":
	float middle_arithmetic(const float x1, const float x2, const float x3, const float x4)
	float middle_arithmetic2(const float x1, const float x2)
	float middle_harmonic(const float x1, const float x2, const float x3, const float x4)
	float middle_harmonic2(const float x1, const float x2)
	float middle_quantil(const float x1, const float x2, const float x3, const float x4)
	float middle_median(const float x1, const float x2, const float x3, const float x4)
	float middle_quad(const float x1, const float x2, const float x3, const float x4)
	float middle_quad2(const float x1, const float x2)
	float middle_cubic(const float x1, const float x2, const float x3, const float x4)
	float middle_cubic2(const float x1, const float x2)
	float middle_geometric(const float x1, const float x2, const float x3, const float x4)
	float middle_geometric2(const float x1, const float x2)
	float middle_hoelder(const float x1, const float x2, const float x3, const float x14)
	float middle_hoelder2(const float x1, const float x2)

cdef extern from "array.h":
	ctypedef struct dimension_t:
		int cnt
		int size

	ctypedef struct array_t:
		dimension_t * config
		int size
		size_t entrysize
		void * entries
	
	ctypedef struct array_iterator_t:
		size_t entrysize
		int length
		int index
		array_t * array
	
	array_iterator_t * array_iterator_new(array_t *  array)
	bool array_iterator_has_next(array_iterator_t *  iterator)
	void * array_iterator_next(array_iterator_t *  iterator)
	void array_iterator_free(array_iterator_t *  iterator)

	
cdef extern from "noise.h":
	ctypedef struct noise_t:
		array_t * map
		float min, max

	ctypedef struct diamond_square_t:
		noise_t * noise
		int length
		float startseed, seed, reduction
		float (*middlefunc)(const float x1, const float x2, const float x3, const float x4)

	ctypedef struct midpoint_displacement_t:
		noise_t * noise
		int length
		float startseed, seed, reduction
		float (*middlefunc)(const float x1, const float x2, const float x3, const float x4)
		float (*middlefunc2)(const float x1, const float x2)

	noise_t * noise_new(const unsigned int width, const unsigned int height)
	void noise_free(noise_t * noise)
	void create_diamond_square(diamond_square_t * param)
	void create_midpoint_displacement( midpoint_displacement_t * param )


cdef c_make_noise():
	cdef int w = 513
	cdef int h = w
	srand(time(NULL))
	
	cdef noise_t * noise = noise_new(w, h)
	
	cdef midpoint_displacement_t md_param
	md_param.noise = noise
	md_param.length = w-1
	md_param.startseed = 1.0
	md_param.seed = 1.0
	md_param.reduction = 0.5
	md_param.middlefunc = middle_arithmetic
	md_param.middlefunc2 = middle_arithmetic2
	create_midpoint_displacement(&md_param)
	
	cdef array_iterator_t * it = array_iterator_new(noise.map);
	
	result = []
	cdef float curcolor, colval
	while(array_iterator_has_next(it)):
		curcolor = (<float *>array_iterator_next(it))[0]
		colval = interpolate_lin(curcolor, noise.min, 0.0, noise.max, 255.0);
		result.append(colval)
	
	array_iterator_free(it);
	
	noise_free(noise)
	
	return result

def make_noise():
	return c_make_noise()

	