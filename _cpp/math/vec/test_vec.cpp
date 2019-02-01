#if 0
/**
	This is a Test programm for vec 2 and 3 and 4 implementation.
*/
#endif

#include <iostream>
using namespace std;
#include <cassert>

#include "vec.h"

int 
main() {

	#ifdef debug
		cout << "Start testing vec2:\n";
	#endif
	
	Vec2 zero = Vec2();
	Vec2 vec = Vec2();
	
	assert(vec == zero);
	
	vec = Vec2(1.f, 2.f);
	assert(vec.get_x() == 1.f);
	assert(vec.get_y() == 2.f);
	
	#ifdef debug
		cout << vec << endl;
	#endif
	
	Vec2 vec2 = Vec2(3.f, 4.f);
	
	#ifdef debug
		cout << "v: " << vec << " v2: " << vec2 << endl;
	#endif
	
	Vec2 vec3 = vec + vec2;
	vec2 += vec;
	
	#ifdef debug
		cout << "v+[=]v2 v3: " << vec3 << " v2: " << vec2 << endl ;
	#endif
	
	assert(vec3 == vec2);
	
	#ifdef debug
		cout << "v: " << vec << " v2: " << vec2 << endl;
	#endif
	
	vec3 = vec2 - vec;
	vec2 -= vec;
	
	#ifdef debug
		cout << "v-[=]v2 v3: " << vec3 << " v2: " << vec2 << endl ;
	#endif
	
	assert(vec3 == vec2);
	
	#if 0
		//Test if Vecor negation
	#endif
	
	#ifdef debug
		cout << "v: " << vec << " -v: " << -vec << endl;
	#endif
	
	Vec2 vec4 = -vec;
	
	assert((vec4 != vec) && (vec4 == -vec));
		
	
	#if 0
		//Test Vector length
	#endif

	vec = Vec2(5.f, 6.f);
	#ifdef debug
		cout << "v: " << vec << " length: " << vec.length() << endl;
	#endif
	assert(vec.length() == 7.8102496759066543941297227357591f);

	#if 0
		//Test Vector multiplications
	#endif
	
	vec = {2.f, 3.f};
	vec2 = {2.f, 3.f};
	float factor = 2.f;
	
	float skalarproduct = vec * vec2;
	assert(skalarproduct == 13.0f);
	
	#ifdef debug
		cout << "v: " << vec << endl;
	#endif
	
	vec3 = vec * factor;
	vec *= factor;
	
	#ifdef debug
		cout << "v*2: " << vec << endl;
	#endif
	
	assert(vec == vec3);
	
	#if 0
		//Test Vector normalisation
	#endif
	
	vec = { 2.f, 3.f };
	#ifdef debug
		cout << "v: " << vec << endl;
	#endif
	vec.norm();
	#ifdef debug
		cout << "v.norm: " << vec << endl;
	#endif
	assert(vec.get_x() == 0.554700196225229122018341733457f);
	assert(vec.get_y() == 0.8320502943378436830275126001855f);

	#if 0
		//Test Vector 2D Cross product
	#endif
	
	vec = {2.0f, 3.0f};
	vec2 = {1.0f, 2.0f};
	
	assert(vec.cross(vec2) == 1.f);

	#if 0
		//Test Vector 2D angle
	#endif
	
	vec = {0.f, 1.f};
	vec2 = {1.f, 0.f};
	
	float angle_rad = vec.angle(vec2);
	float degree = angle_rad * (180 / M_PI);
	assert(degree <= 90.0001f && degree >= 90.f );
	#if 0
		//Test Vector 2D orthogonality
	#endif

	vec = {0.0f, 1.0f};
	vec2 = {1.0f, 0.0f};
	vec3 = {1.0f, 0.0f};
	
	assert(vec.isorthogonal(vec2));
	assert(!vec.isorthogonal(vec));

	#ifdef debug
		printf("End testing vec2:\n");
	#endif

	#ifdef debug
		printf("Start testing vec3:\n");
	#endif
	
	#if 0
	//Test nzero vector
	#endif
	
	Vec3 _zero = Vec3();
	Vec3 _vec = Vec3();
	
	assert(_vec == _zero);
	
	_vec = Vec3(1.f, 2.f, 3.f);
	assert(_vec.get_x() == 1.f);
	assert(_vec.get_y() == 2.f);
	assert(_vec.get_z() == 3.f);
	
	#ifdef debug
		cout << _vec << endl;
	#endif
	
	#if 0
	//Test if Vecor additions
	#endif

	Vec3 _vec2 = {1.1f, 1.1f, 1.1f};
	
	#ifdef debug
		cout << "v" << _vec << "v2" << _vec2 << endl;
	#endif
	
	Vec3 _vec3 = _vec + _vec2;
	_vec += _vec2;
	
	#ifdef debug
		cout << "v+v2" << _vec3 << endl;
		cout << "v+=v2" << _vec << endl;
	#endif
	
	assert(_vec3 == _vec );
	
	#if 0
		//Test if Vecor difference
	#endif
	
	_vec = {2.0f, 2.0f, 2.0f};
	_vec2 = {1.0f, 1.0f, 1.0f};
	
	#ifdef debug
		cout << "v" << _vec << "v2" << _vec2 << endl;
	#endif
	
	_vec3 = _vec - _vec2;
	_vec -= _vec2;
	
	#ifdef debug
		cout << "v-v2" << _vec3 << endl;
		cout << "v-=v2" << _vec << endl;
	#endif
	
	assert(_vec3 == _vec );
	
	
	
	#if 0
		//Test if Vecor negation
	#endif
	
	#ifdef debug
		cout << "v: " << _vec << " -v: " << -_vec << endl;
	#endif
	
	Vec3 _vec4 = -_vec;
	
	assert((_vec4 != _vec) && (_vec4 == -_vec));
	

	#if 0
		//Test Vector length
	#endif
	
	_vec = {5.f, 6.f, 7.f};
	
	#ifdef debug
		cout << "v: " << _vec << " length: " << _vec.length() << endl;
	#endif
	assert(_vec.length() == 10.488088481701515469914535136799f);
	
	#if 0
		//Test Vector multiplications
	#endif
	
	_vec = {2.f, 3.f, 4.f};
	_vec2 = {2.f, 3.f, 4.f};
	factor = 2.f;
	
	skalarproduct = _vec * _vec2;
	assert(skalarproduct == 29.0f);
	
	#ifdef debug
		cout << "v: " << _vec << endl;
	#endif
	
	_vec3 = _vec * factor;
	_vec *= factor;
	
	#ifdef debug
		cout << "v*2: " << _vec << endl;
	#endif
	
	assert(_vec == _vec3);
	

	#if 0
		//Test Vector normalisation
	#endif

	_vec = { 2.f, 3.f, 4.f};
	#ifdef debug
		cout << "v: " << _vec << endl;
	#endif
	_vec.norm();
	#ifdef debug
		cout << "v.norm: " << _vec << endl;
	#endif
	assert(_vec.get_x() == 0.37139067635410372629315244769244f);
	assert(_vec.get_y() == 0.55708601453115558943972867153866f);
	assert(_vec.get_z() == 0.74278135270820745258630489538488f);
	
	#if 0
		//3D Cross product
	#endif
	
	_vec = {1.0f, -5.0f, 2.0f};
	_vec2 = {2.0f, 0.0f, 3.0f};
	
	#ifdef debug
		cout << "v: " << _vec << "v2: " << _vec2 << endl;
	#endif
	
	_vec3 = _vec.cross(_vec2);
	
	#ifdef debug
		cout << "v.cross(v2): " << _vec3 << endl;
	#endif
	
	assert(_vec3.get_x() == -15.0f);
	assert(_vec3.get_y() == 1.0f);
	assert(_vec3.get_z() == 10.0f);

	#if 0
		//3D Spat product
	#endif
	
	_vec = { 2.0f, 0.0f, 5.0f};
	_vec2 = { -1.0f, 5.0f, -2.0f};
	_vec3 = { 2.0f, 1.0f, 2.0f};
	
	#ifdef debug
		cout << "v: " << _vec << "v2: " << _vec2 << "v3: " << _vec3 << endl;
	#endif
	
	float spatvolume = _vec.spat(_vec2, _vec3);
	
	#ifdef debug
		cout << "v.spat(v2, v3): " << spatvolume << endl;
	#endif
	
	assert(spatvolume == -31.0f);
	
	#if 0
		//Test Vector 3D angle
	#endif

	_vec = {0.0f, 1.0f, 0.f};
	_vec2 = {1.0f, 0.0f, 0.f};
	
	angle_rad = _vec.angle(_vec2); 
	degree = angle_rad * (180 / M_PI);
	assert(degree <= 90.0001f && degree >= 90.f );

	#if 0
		//Test Vector 3D orthogonality
	#endif
	
	_vec = {0.0f, 1.0f, 0.f};
	_vec2 = {1.0f, 0.0f, 0.f};
	_vec3 = {1.0f, 0.0f, 0.f};
	
	assert(_vec.isorthogonal(_vec2));
	assert(!_vec.isorthogonal(_vec));
	
	#if 0
		//test place of point
	#endif
	
	Vec3 start = {0.f, 0.f, 0.f};
	Vec3 end = {2.f, 2.f, 0.f};
	Vec3 point = {0.5f, 1.5f, 0.f};
	
	float place = point.place(start, end);
	assert(place < 0.f);
	
	start = {0.f, 0.f, 0.f};
	end = {2.f, 2.f, 0.f};
	point = {1.5f, 0.5f, 0.f};
	
	place = point.place(start, end);
	assert( place > 0.f);
	
	start = {0.f, 0.f, 0.f};
	end = {2.f, 2.f, 0.f};
	point = {1.f, 1.f, 0.f};
	
	place = point.place(start, end);
	Vec3 testdiff = point - start;
	assert(place == 0.f && testdiff.get_x() >= 0.f && testdiff.get_y() >= 0.f);

	start = {0.f, 0.f, 0.f};
	end = {2.f, 2.f, 0.f};
	point = {-1.f, -1.f, 0.f};
	
	place = point.place(start, end);
	testdiff = point - start;
	assert(place == 0.f && testdiff.get_x() < 0.f && testdiff.get_y() < 0.f);
	
	#if 0
		//test matrix multiply with vector
	#endif
	Mat2 mat2 = { 1.f, 2.f, 3.f, 4.f};
	vec2 = { 2.f, 3.f};
	vec3 = Vec2(vec2);
	Vec2 vec2_result = { 8.f, 18.f};
	
	vec3 = vec2 * mat2;
	vec2 *= mat2;
	
	assert(vec3 == vec2_result);
	assert(vec2 == vec2_result);
	assert(vec2 == vec3);
	
	#if 0
		//test matrix multiply with vector
	#endif
	
	Mat3 mat3 = { 1.f, 0.f, 2.f, 0.f, 0.f, 4.f, 1.f, -1.f, 1.f};
	_vec2 = { 2.f, 2.f, 0.f};
	_vec3 = Vec3(_vec2);
	Vec3 vec3_result = { 2.f, 0.f, 0.f};
	
	_vec3 = _vec2 * mat3;
	_vec2 *= mat3;
	
	assert(_vec3 == vec3_result);
	assert(_vec2 == vec3_result);
	assert(_vec2 == _vec3);

	#if 0
		//test matrix multiply with vector
	#endif
	
	Mat3 rotx_mat = Mat3::create_rot_x_mat(90.f);
	Mat3 roty_mat = Mat3::create_rot_y_mat(90.f);
	Mat3 rotz_mat = Mat3::create_rot_z_mat(90.f);
	
	Vec3 vec31 = { 1.f, 0.f, 0.f};
	Vec3 vec32 = { 1.f, 0.f, 0.f};
	Vec3 vec33 = { 1.f, 0.f, 0.f};
	
	Vec3 vec31_result = { 1.f, 0.f, 0.f};
	
	#ifdef debug
		cout << "before rot x: " << vec31 << endl;
	#endif
	vec31 *= rotx_mat;
	#ifdef debug
		cout << "rot x: " << vec31 << endl;
	#endif
	assert(vec31 == vec31_result);

	#ifdef debug
		cout << "before rot y: " << vec32 << endl;
	#endif
	vec32 *= roty_mat;
	#ifdef debug
		cout << "rot y: " << vec32 << endl;
	#endif
	assert(vec32.get_z() == -1.f);
	
	#ifdef debug
		cout << "before rot z: " << vec33 << endl;
	#endif
	vec33 *= rotz_mat;
	#ifdef debug
		cout << "rot z: " << vec33 << endl;
	#endif
	assert(vec33.get_y() == 1.f );
	
	#ifdef debug
		cout << "End testing vec3:\n";
	#endif	
	
	return 0;
}