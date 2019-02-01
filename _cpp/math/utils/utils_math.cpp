
#include "utils_math.h"

float MathUtils::interpolate_lin(const float x, const float x0, const float f0, const float x1, const float f1) {
	float result = 0.f;
	
	if ( f0 != 0.0f) {
		result += f0*((x1 - x)/(x1 - x0));
	} else {
		result = f0;
	}
	
	if ( f1 != 0.0f) {
		result += f1*((x - x0)/(x1 - x0));
	}
	
	return result;
}
int MathUtils::compare_floats(const void* a, const void* b) {
	const float arg1 = *(const float*)a;
	const float arg2 = *(const float*)b;
	
	if (arg1 < arg2) return -1;
	if (arg1 > arg2) return 1;
	return 0;
}
float MathUtils::seedrndlh(const float &lnum, const float &hnum){
	return lnum + ((float)rand()/((float)(RAND_MAX)/(hnum-lnum)));
}
float MathUtils::seedrnd(const float seed){
	return (((float)rand()/(float)(RAND_MAX)) * 2.f * seed) - seed;
}
float MathUtils::rand_path_deg(const int &maxdeg) {
	float deg = (float)(rand() % maxdeg) + (rand()%100 * 0.01f);
	return (rand() % 2 == 0 ? -deg: deg);
}


void FractalPoint::inside_mandelbrot_set(const std::complex<float> &point, const int &cntiterations) {
	this->cpoint = std::complex<float>(0.f, 0.f);
	this->isin = true;
	this->iterations = 0;
	for(; this->iterations < cntiterations; ++this->iterations){
		this->cpoint = std::pow(this->cpoint, 2) + point;
		this->abs= std::abs(this->cpoint);
		if ( this->abs > 2.f ){
			this->isin = false;
			break;
		}
	}
	this->spoint = point;
}

void FractalPoint::inside_julia_set(std::complex<float> &point, const std::complex<float> &c, const int &cntiterations, polyfunc pfunc) {
	this->cpoint = point;
	this->isin = false;
	int i = 0;
	for(; i < cntiterations; ++i){
		this->cpoint = pfunc(this->cpoint, c);
		this->abs = std::abs(this->cpoint);
		if ( this->abs > 2.f ){
			this->isin = true;
			break;
		}
	}
	this->spoint = point;
}
void Barycentric::calc_from(const Vec3 &v0, const Vec3 &v1, const Vec3 &v2, const Vec3 &p) {
	//top left edge test
	//this->inside = true;
	this->inside = false;
	const Vec3 _v0 = v0, _v1 = v1, _v2=v2,_p=p;
	//maybe we have a counter clockwise problem
	this->w0_12 = (_p.get_x() - _v1.get_x()) * (_v2.get_y() - _v1.get_y()) - (_p.get_y() - _v1.get_y()) * (_v2.get_x() - _v1.get_x());
	if (this->w0_12 < 0.f) return;
	this->w1_20 = (_p.get_x() - _v2.get_x()) * (_v0.get_y() - _v2.get_y()) - (_p.get_y() - _v2.get_y()) * (_v0.get_x() - _v2.get_x());    
	if (this->w1_20 < 0.f) return;
	this->w2_01 = (_p.get_x() - _v0.get_x()) * (_v1.get_y() - _v0.get_y()) - (_p.get_y() - _v0.get_y()) * (_v1.get_x() - _v0.get_x());
	if (this->w2_01 < 0.f) return;
	
	//top left edge test
	//vec3_t edge0, edge1, edge2;
	//
	//vec3_sub_dest(&edge0, v2, v1);
	//vec3_sub_dest(&edge1, v0, v2);
	//vec3_sub_dest(&edge2, v1, v0);
	
	//counter clockwise
	//bc->inside = ( bc->w0_12 <= 0.f && bc->w1_20 <= 0.f && bc->w2_01 <= 0.f );
	//clockwise
	this->inside = true; //( bc->w0_12 >= 0.f && bc->w1_20 >= 0.f && bc->w2_01 >= 0.f );
	//top left edge test
	//bc->inside &= (bc->w0_12 == 0.f ? ((edge0.y == 0.f && edge0.x > 0.f) || edge0.y > 0.f) : bc->w0_12 > 0.f );
	//bc->inside &= (bc->w1_20 == 0.f ? ((edge1.y == 0.f && edge1.x > 0.f) || edge1.y > 0.f) : bc->w1_20 > 0.f );
	//bc->inside &= (bc->w2_01 == 0.f ? ((edge2.y == 0.f && edge2.x > 0.f) || edge2.y > 0.f) : bc->w2_01 > 0.f );
	this->bc0 = this->w0_12 / this->area;
	this->bc1 = this->w1_20 / this->area;
	this->bc2 = this->w2_01 / this->area;
}
