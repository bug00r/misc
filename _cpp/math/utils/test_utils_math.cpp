#if 0
/**
	This is a Test programm for math utils
*/
#endif

//#include <stdlib.h>
//#include <stdio.h>


#include "utils_math.h"

#include <cassert>
#include <ctime>

#include <iostream>
using namespace std;

int 
main() {
	#ifdef debug
		cout << "Start testing math utils:\n";
	#endif
	
	#if 0
		//test randomseed limits
	#endif
	srand(time(NULL));
	
	#ifdef debug
		cout << "random numbers from -10 - 10\n" << endl;
	#endif
	
	float rlh = MathUtils::seedrndlh(0.f, 10.f);
	
	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= 0.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(0.f, 10.f);
	
	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= 0.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(0.f, 10.f);
	
	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= 0.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(0.f, 10.f);

	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= 0.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(-10.f, 10.f);

	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= -10.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(-10.f, 10.f);

	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= -10.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(-10.f, 10.f);

	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= -10.f && rlh <= 10.f);
	
	rlh = MathUtils::seedrndlh(-10.f, 10.f);

	#ifdef debug
		cout << "->" << rlh << '\n' << endl;
	#endif
	assert(rlh >= -10.f && rlh <= 10.f);

	#if 0
		//test random numbers
	#endif
	
	float random = MathUtils::rand_path_deg(32);
	assert(random >= -32.f && random <=32.f);
	random = MathUtils::rand_path_deg(22);
	assert(random >= -22.f && random <=22.f);
	random = MathUtils::rand_path_deg(12);
	assert(random >= -12.f && random <=12.f);
	
	random = MathUtils::rand_path_deg(2);
	assert(random >= -2.f && random <=2.f);
	random = MathUtils::rand_path_deg(32);
	assert(random >= -32.f && random <=32.f);
	random = MathUtils::rand_path_deg(32);
	assert(random >= -32.f && random <=32.f);
	random = MathUtils::rand_path_deg(32);
	assert(random >= -32.f && random <=32.f);
	
	#if 0
		//test linear interpolation
	#endif
	
	float intres = MathUtils::interpolate_lin(0.f, -1.f, 0.f, 1.f, 255.f);
	assert(intres == 127.5f);
	
	intres = MathUtils::interpolate_lin(1.f, -1.f, 0.f, 1.f, 255.f);
	assert(intres == 255.f);
	intres = MathUtils::interpolate_lin(-1.f, -1.f, 0.f, 1.f, 255.f);
	assert(intres == 0.f);
	
	#if 0
		//test is inside mandelbrotset
	#endif
	
	FractalPoint result;
	int iteratrions = 20;
	std::complex<float> cp = std::complex<float>(-2.f, 1.f);
	
	result.inside_mandelbrot_set(cp, iteratrions);
	assert(!result.get_isin());
	
	cp = std::complex<float>(.3f, .3f);
	result.inside_mandelbrot_set(cp, iteratrions);
	assert(result.get_isin());
	
	#if 0
		/**
			test if point is inside or outside triangle
		*/
	#endif
	
	Vec3 v0 = {0.f, 0.f, 0.f};
	Vec3 v1 = {2.f, 2.f, 0.f};
	Vec3 v2 = {2.f, 0.f, 0.f};
	Vec3 point_ = {1.5f, .5f, 0.f};
	
	Barycentric bc;
	bc.set_area(v2.place(v0, v1)); 
	
	bc.calc_from(v0, v1, v2, point_);
	assert(bc.get_inside());
	
	point_ = {1.f, 1.f, 0.f};
	
	bc.calc_from(v0, v1, v2, point_);
	assert(bc.get_inside());
	
	point_ = {5.f, 1.f, 0.f};
	
	bc.calc_from(v0, v1, v2, point_);;
	assert(!bc.get_inside());
	
	point_ = {1.f, 1.f, 0.f};
	
	bc.calc_from(v0, v1, v2, point_);;
	assert(bc.get_inside());
	
	#if 0
		/** Debug tests
			vec3(x=140.800003, y=115.199997, z=-1.500000)
			vec3(x=125.866669, y=140.800003, z=-1.500000)
			vec3(x=113.066666, y=115.199997, z=-1.500000)
		*/
	#endif
	
	v0 = {140.800003f, 115.199997f, -1.500000f};
	v1 = {125.866669f, 140.800003f, -1.500000f};
	v2 = {113.066666f, 115.199997f, -1.500000f};
	point_ = {130.5f, 110.f, 0.f};
	
	#if 0
		/**
			summary of barycentric coordinates must be 1 :)
		*/
	#endif
	
	assert((bc.get_bc0() + bc.get_bc1() + bc.get_bc2()) == 1.f);
	
	#if 0
		/**
			special barycentric test from:
			https:www.scratchapixel.com/lessons/3d-basic-rendering/rasterization-practical-implementation/visibility-problem-depth-buffer-depth-interpolation
			
			which produces invalid result for a line example.
		*/
	#endif
		
	Vec3 spv0 = {0.f, 0.f,0.f}; //absolut 0 world coordinate
	Vec3 spv1 = {-2.f, 1.f,0.f}; //V0'
	Vec3 spv2 = {.4f, 1.f,0.f}; //V1'
	Vec3 sppoint_ = {0.f, 1.f,0.f}; //P'
	
	Barycentric spbcc;
	spbcc.set_area(spv2.place(spv0, spv1)); 
	spbcc.calc_from(spv0, spv1, spv2, sppoint_);
	
	#ifdef debug
		cout << "spbcc: " << spbcc.get_bc0() << ' ' << spbcc.get_bc1() << ' ' << spbcc.get_bc2() << endl;
	#endif
	
	#if 0
		//P.z=V0.z*(1−λ)+V1.z∗*λ =2*1.666+5*0.833=4.5
	#endif
	float Pz = ((2*1)-(2*spbcc.get_bc2())) + (5*spbcc.get_bc2());
	#ifdef debug
		cout << "P.z:" << Pz << "== 4.5\n";
	#endif
	
	assert(Pz == 4.5f);
	
	#if 0
		/**
			special barycentric test from:
			https:www.scratchapixel.com/lessons/3d-basic-rendering/rasterization-practical-implementation/visibility-problem-depth-buffer-depth-interpolation
			
			which produces CORRECT RESULT result for a line.
			
			This is for a triangle: 1/P.z=1/V0.z*λ0+1/V1.z*λ1+1/V2.z*λ2.
		*/
	#endif
	
	Pz = (((1./2)*1)-((1./2)*spbcc.get_bc2())) + ((1./5)*spbcc.get_bc2());
	#ifdef debug
		cout << "1/P.z: " << Pz << " == 0.25 and P.z " << (1./Pz) << " == 4\n";
	#endif
	
	assert(Pz == .25f);
	assert(1./Pz == 4.f);


	#ifdef debug
		cout << "End testing math utils:\n";
	#endif
	
	return 0;
}