#ifndef UTILS_MATH_H
#define UTILS_MATH_H

#include <iostream>
using namespace std;

#include <complex>

#include "vec.h"
#include "mat.h"

#if 0
/**
	This is a utils lib for difference more or less elegance consolidated functions
*/
#endif

/**
//typedef struct {
//	float complex cpoint;
//	float complex spoint;
//	float abs;
//	int iterations;
//	bool isin;
//} mandelbrot_point_t;
//
//typedef struct {
//	int iterations;
//	bool isin;
//	float complex cpoint;
//	float complex spoint;
//	float abs;
//} julia_point_t;
//
*/
typedef std::complex<float> (*polyfunc)(const std::complex<float> &cp, const std::complex<float> &c);

class FractalPoint {
	public:
		std::complex<float> get_cpoint() const { return this->cpoint; }
		std::complex<float> get_spoint() const { return this->cpoint; }
		float get_abs() const { return this->abs; }
		int get_iterations() const { return this->iterations; }
		bool get_isin() const { return this->isin; }

		void inside_mandelbrot_set(const std::complex<float> &point, const int &cntiterations);
		//
		//#if 0
		///**
		//	cals if point is inside julia set. Stores results inside of julia_point_t
		//*/
		//#endif
		//void inside_julia_set(const float complex *point, const float complex *c, const int cntiterations, 
		//				      julia_point_t *result, float complex (*polyfunc)(const float complex *cp, const float complex *c));
		void inside_julia_set(std::complex<float> &point, const std::complex<float> &c, const int &cntiterations, polyfunc pfunc);
		
	private:
		friend std::ostream & operator<<(std::ostream &os, const FractalPoint& m);
	    std::complex<float> cpoint, spoint;
	    float abs;
	    int iterations;
	    bool isin;
};

/**
	//

//typedef struct {
//	float w0_12;
//	float w1_20;
//	float w2_01;
//	float area;
//	float bc0;
//	float bc1;
//	float bc2;
//	bool inside;
//} barycentric_t;
*/
class Barycentric {
	public:
		
		float get_w0_12() const { return w0_12; } 
		float get_w1_20() const { return w1_20; } 
		float get_w2_01() const { return w2_01; } 
		float get_area() const{ return area;}
		void set_area(const float &_area) { this->area = _area; }
		float get_bc0() const { return bc0;} 
		float get_bc1() const { return bc1;} 
		float get_bc2() const { return bc2;} 
		bool get_inside() const { return inside;} 
		
		//prototype so we cvan handle with this
		//void is_inside_triangle(const vec3_t * v0, const vec3_t * v1, const vec3_t * v2, const vec3_t * p, barycentric_t * bc);
		void calc_from(const Vec3 &v0, const Vec3 &v1, const Vec3 &v2, const Vec3 &p);

	private:
		friend std::ostream & operator<<(std::ostream &os, const Barycentric& m);
		float w0_12, w1_20, w2_01, area, bc0, bc1, bc2;
		bool inside;
};

class MathUtils {
	public:
		static float interpolate_lin(const float x, const float x0, const float f0, const float x1, const float f1);
		static int compare_floats(const void* a, const void* b);
		static float seedrndlh(const float &lnum, const float &hnum);
		static float seedrnd(const float seed);
		static float rand_path_deg(const int &maxdeg);
};

#endif
