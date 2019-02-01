from libc.stdlib cimport free


cdef extern from "color.h":
	ctypedef struct cRGB_t:
		float r,g,b
	
	cRGB_t * create_crgb( const float r, const float g, const float b)
	void crgb_add(cRGB_t *  color, const float add)
	void crgb_print(const cRGB_t * color)


cdef class Py_cRGB_t:
	cdef cRGB_t* c_color
	def __cinit__(self, float r, float g, float b):
		self.c_color = create_crgb( r, g, b)

	cdef __add_(self, float value):
		crgb_add(self.c_color, value)

	cdef __print(self):
		crgb_print(self.c_color)
	
	cdef cRGB_t* ccol(self):
		return self.c_color
	
	def print_color(self):
		self.__print()
		
	def add(self, value):
		self.__add_(value)

	def __dealloc__(self):
		free(self.c_color)
		

cdef class Py_col_factory:
	def add_alot(self, cRGB_t * color):
		crgb_add(color, 500000.0)
		crgb_add(color, 500000.0)
		crgb_add(color, 500000.0)

		
def add_more(col_val, val):
	col_val.add(val)

def make_color_py(r,g,b):
	return Py_cRGB_t(r, g, b)

def make_color(r, g, b):
	cdef cRGB_t * col = create_crgb( r, g, b)
	
	crgb_add(col, 15)
	
	result = (col.r, col.g, col.b)
	
	free(col)
	return result

"""This auto conversion from struct into dict is stange, and i don't know if there is a memory leak 

ALSO prevent this...only ctype inside of cfunctions"""
def create_color(r, g, b):
	cdef cRGB_t * col = create_crgb( r, g, b)
	
	crgb_add(col, 15)
	
	return col[0]

def free_color(color):
	print(color)
	#cdef cRGB_t * col = <cRGB_t*>color
	#free(col)

"""	
typedef struct {
	float r, g, b;
} cRGB_t;

#if 0
	/**
		Creates new color object
	*/
#endif
cRGB_t * create_crgb( const float r, const float g, const float b);
#if 0
	/**
		copy values from color2 into color.
	*/
#endif
void crgb_crgb_copy(cRGB_t *  color, const cRGB_t *  color2);
//no need for color_t its only  color2 = color1

#if 0
	/**
		Add two colors and store result in color.
	*/
#endif
void crgb_crgb_add(cRGB_t *  color, const cRGB_t *  color2);
//no need for color_t its only color1 += color2

#if 0
	/**
		Add color value to each value of rgba. If you want to sub then add negative number
	*/
#endif
void crgb_add(cRGB_t *  color, const float add);
void color_add(color_t *  color, const int add);
void color_add_dest(color_t *  dest, const color_t *  color, const int add);
#if 0
	/**
		Multiplies color value to each value of rgba. If you want to divife then multiply antivalent number
	*/
#endif
void crgb_mul(cRGB_t *  color, const float mul);
void color_mul(color_t *  color, const int mul);
void color_mul_dest(color_t *  dest, const color_t *  color, const int mul);
void color_mulf(color_t *  color, const float mul);
void color_mulf_dest(color_t *  dest, const color_t *  color, const float mul);
#if 0
	/**
		prints color value
	*/
#endif
void crgb_print(const cRGB_t *  color);
void color_print(const color_t *  color);

#if 0
	/**
		calculates color with new brightness for color range 0 to 255. Result is stored in dest.
	*/
#endif
void crgb_brightness_255_dest(cRGB_t *  dest, const cRGB_t *  color, const float brightness);
void color_brightness_255_dest(/** cRGB_t*/color_t *  dest, /** cRGB_t*/const color_t *  color, const int brightness);

#if 0
	/**
		calculates color with new contrast_factor for wanted contrast for color range 0 to 255. Result is stored in dest.
	*/
#endif
float crgb_contrast_factor_255(const float contrast);
float color_contrast_factor_255(const int contrast);

#if 0
	/**
		calculates color with new contrast for color range 0 to 255. Result is stored in dest.
	*/
#endif
void crgb_contrast_255_dest(cRGB_t *  dest, const cRGB_t *  color, const float contrast_factor);
void color_contrast_255_dest(/** cRGB_t*/color_t * dest, /** cRGB_t*/const color_t * color, const float contrast_factor);

#endif
"""