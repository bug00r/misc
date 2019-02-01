#if 0
/**
	This is a Test programm for vec 2 and 3 implementation.
*/
#endif

#include "mat.h"
#include <cassert>
int 
main() {

	#ifdef debug
		printf("Start testing mat2:\n");
	#endif
	 
	Mat2 mat = Mat2();
	Mat2 mat2 = Mat2(1.f, 2.f, 3.f, 4.f);
	Mat2 mat3 = Mat2(mat2);
	
	#ifdef debug
	cout << mat << endl;
	cout << mat2 << endl;
	cout << mat3 << endl;
	#endif
	
	assert(mat2 == mat3);
	assert(mat2 != mat);

	#if 0
		//Test mat2 addition
	#endif
	
	mat = { 1.f, 2.f, 3.f, 4.f};
	mat2 = { 1.f, 2.f, 3.f, 4.f};
	mat3 = { 2.f, 4.f, 6.f, 8.f};
	
	#ifdef debug
	cout << "m: " << mat << endl;
	cout << "m2: " << mat2 << endl;
	cout << "m3: " << mat3 << endl;
	
	cout << "m+3: " << (mat + 3.f) << endl;
	#endif
	
	mat3 = mat + mat2;
	mat2 += mat;
	
	#ifdef debug
	cout << "m+m2: " << mat3 << endl;
	cout << "m2+=m: " << mat2 << endl;
	#endif
	
	assert(mat3 == mat2);
	
	#if 0
		//Test mat2 subtraction
	#endif
	
	mat = { 1.f, 2.f, 3.f, 4.f};
	mat2 = { 1.f, 2.f, 3.f, 4.f};
	mat3 = { 2.f, 4.f, 6.f, 8.f};
	
	#ifdef debug
	cout << "m: " << mat << endl;
	cout << "m2: " << mat2 << endl;
	cout << "m3: " << mat3 << endl;
	
	cout << "m-3: " << (mat - 3.f) << endl;
	#endif
	
	mat3 = mat - mat2;
	mat2 -= mat;
	
	#ifdef debug
	cout << "m-m2: " << mat3 << endl;
	cout << "m2-=m: " << mat2 << endl;
	#endif
	
	assert(mat3 == mat2);
	
	#if 0
		//Test mat2 copy
	#endif
	
	#ifdef debug
	cout << "m: " << mat << endl;
	cout << "m3: " << mat3 << endl;
	#endif
	
	mat = mat3;
	
	#ifdef debug
	cout << "m==m3: " << (mat3==mat) << endl;
	#endif
	
	assert(mat==mat3);

	#if 0
		//Test mat2 mul
	#endif
	
	mat = { 1.f, 2.f, 3.f, 4.f};
	mat2 = { 1.f, 2.f, 3.f, 4.f};
	mat3 = { 7.f, 10.f, 15.f, 22.f};
	Mat2 res = { 7.f, 10.f, 15.f, 22.f};
	
	#ifdef debug
	cout << "m: " << mat << endl;
	cout << "m2: " << mat2 << endl;
	cout << "m3: " << mat3 << endl;
	#endif
	
	mat3 = mat * mat2;
	mat2 *= mat;
	
	#ifdef debug
	cout << "m*m2: " << mat3 << endl;
	cout << "m2*=m: " << mat2 << endl;
	#endif
	
	assert(mat3 == mat2);
	assert(mat2 == res);
	
	#ifdef debug
	cout << "m*3: " << (mat * 3.f) << endl;
	#endif
	
	#if 0
		//Test mat2 transponse
	#endif
	
	mat = { 1.f, 2.f, 3.f, 4.f};
	mat2 = { 1.f, 3.f, 2.f, 4.f };
	
	#ifdef debug
	cout << "m: " << mat << endl;
	#endif
	
	mat.transponse();
	
	#ifdef debug
	cout << "m.transponse: " << mat << endl;
	#endif
	
	assert(mat == mat2);
	
	#if 0
		//Test mat2 determinant
	#endif
	
	mat = {1.f,2.f,3.f,4.f};
	assert(mat.det() == -2.f);
	
	#if 0
		//Test mat2 inverse
	#endif
	mat = {1.f,2.f,3.f,4.f};
	mat2 = {1.f,2.f,3.f,4.f};
	mat3 = { 1.f, 0.f, 0.f, 1.f };
	
	#ifdef debug
	cout << "m: " << mat << endl;
	#endif
	mat.inverse();
	
	#ifdef debug
	cout << "m.inv: " << mat << endl;
	#endif
	mat *= mat2;
	
	#ifdef debug
	cout << "m*m2: " << mat << endl;
	#endif
	assert(mat == mat3);
	
	#ifdef debug
		cout << "End testing mat2:\n";
	#endif
	
	#ifdef debug
		cout << "Start testing mat3:\n";
	#endif
	
	Mat3 _mat= { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	Mat3 _mat2 = { 3.f, 3.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	Mat3 _mat3 = Mat3(_mat);
	#ifdef debug
	cout << "m: " << _mat << endl;
	cout << "m2: " << _mat2 << endl;
	cout << "m3: " << _mat3 << endl;
	#endif
	assert(_mat == _mat3);
	assert(_mat != _mat2);
	
	#if 0
		//Test mat3 addition
	#endif
		
	_mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	_mat2 = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	_mat3 = { 2.f, 4.f, 6.f, 8.f, 10.f, 12.f , 14.f, 16.f, 18.f};
	#ifdef debug
	cout << "m: " << _mat << endl;
	cout << "m2: " << _mat2 << endl;
	#endif
	_mat3 = _mat + _mat2;
	_mat2 += _mat;
	
	#ifdef debug
	cout << "m+m2: " << _mat3 << endl;
	cout << "m2+=m: " << _mat2 << endl;
	#endif
	
	assert(_mat3 == _mat2);
	
	_mat3 = _mat2 + 3.f;
	_mat2 += 3.f;
	
	assert(_mat3 == _mat2);
	
	#ifdef debug
	cout << "m2+3: " << _mat3 << endl;
	cout << "m2+=3: " << _mat2 << endl;
	#endif
	
	#if 0
		//Test mat3 subtraction
	#endif
		
	_mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	_mat2 = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	_mat3 = { 2.f, 4.f, 6.f, 8.f, 10.f, 12.f , 14.f, 16.f, 18.f};
	
	#ifdef debug
	cout << "m: " << _mat << endl;
	cout << "m2: " << _mat2 << endl;
	#endif
	
	_mat3 = _mat - _mat2;
	_mat2 -= _mat;
	
	#ifdef debug
	cout << "m-m2: " << _mat3 << endl;
	cout << "m2-=m: " << _mat2 << endl;
	#endif
	
	assert(_mat3 == _mat2);
	
	_mat3 = _mat2 - 3.f;
	_mat2 -= 3.f;
	
	assert(_mat3 == _mat2);
	
	#ifdef debug
	cout << "m2-3: " << _mat3 << endl;
	cout << "m2-=3: " << _mat2 << endl;
	#endif
	
	#if 0
		//Test mat3 mul
	#endif
		
	_mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	_mat2 = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f};
	_mat3 = { 2.f, 4.f, 6.f, 8.f, 10.f, 12.f , 14.f, 16.f, 18.f};
	Mat3 _res = { 30.f, 36.f, 42.f, 66.f, 81.f, 96.f, 102.f, 126.f, 150.f};
	
	#ifdef debug
	cout << "m: " << _mat << endl;
	cout << "m2: " << _mat2 << endl;
	#endif
	
	_mat3 = _mat * _mat2;
	_mat2 *= _mat;
	
	#ifdef debug
	cout << "m*m2: " << _mat3 << endl;
	cout << "m2*=m: " << _mat2 << endl;
	#endif
	
	assert(_mat3 == _res);
	assert(_mat2 == _res);
	
	_mat3 = _mat2 * 3.f;
	_mat2 *= 3.f;
	
	assert(_mat3 == _mat2);
	
	#ifdef debug
	cout << "m2*3: " << _mat3 << endl;
	cout << "m2*=3: " << _mat2 << endl;
	#endif
	
	#if 0
		//Test mat3 transponse
	#endif
	
	_mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f, 7.f, 8.f, 9.f};
	_mat2 = { 1.f, 4.f, 7.f, 2.f, 5.f, 8.f, 3.f, 6.f, 9.f};
	
	_mat.transponse();
	
	assert( _mat == _mat2 );
	
	#if 0
		//Test mat3 determinant
	#endif
	
	_mat = {11.f,2.f,3.f,4.f,5.f,6.f,7.f,8.f,9.f};
	assert(_mat.det() == -30.f);
	
	#if 0
		//Test mat3 inverse
	#endif
	_mat = {1.f, 2.f, 0.f, 2.f, 4.f, 1.f, 2.f, 1.f, 0.f};
	_mat2 = {1.f, 2.f, 0.f, 2.f, 4.f, 1.f, 2.f, 1.f, 0.f};
	_mat3 = { 1.f, 0.f, 0.f, 0.f, 1.f, 0.f, 0.f, 0.f, 1.f};
	
	#ifdef debug
	cout << "m: " << _mat << endl;
	#endif
	_mat.inverse();
	
	#ifdef debug
	cout << "m.inv: " << _mat << endl;
	#endif
	_mat *= _mat2;
	
	#ifdef debug
	cout << "m*m2: " << _mat << endl;
	#endif
	assert(_mat == _mat3);
	
	#ifdef debug
		cout << "End testing mat3:\n";
	#endif
	
	#ifdef debug
		cout << "Start testing mat4:\n";
	#endif

	Mat4 __mat= { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	Mat4 __mat2 = { 2.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	Mat4 __mat3 = Mat4(__mat);
	
	#ifdef debug
	cout << "m: " << __mat << endl;
	cout << "m2: " << __mat2 << endl;
	cout << "m3: " << __mat3 << endl;
	#endif
	
	assert(__mat == __mat3);
	assert(__mat != __mat2);
	
	#if 0
		//Test mat4 addition
	#endif
	
	__mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat2 = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat3 = { 2.f, 4.f, 6.f, 8.f, 10.f, 12.f , 14.f, 16.f, 18.f, 20.f, 22.f,24.f,26.f,28.f,30.f,32.f};

	#ifdef debug
	cout << "m: " << __mat << endl;
	cout << "m2: " << __mat2 << endl;
	cout << "m3: " << __mat3 << endl;
	#endif
	
	__mat3 = __mat2 + __mat;
	__mat2 += __mat;
	
	#ifdef debug
	cout << "m2+m: " << __mat2 << endl;
	cout << "m2+=m: " << __mat3 << endl;
	#endif
	
	assert(__mat3 == __mat2);
	assert(__mat3 != __mat);
	
	__mat3 = __mat2 + 4.f;
	__mat2 += 4.f;
	
	#ifdef debug
	cout << "m2+4: " << __mat2 << endl;
	cout << "m2+=4: " << __mat3 << endl;
	#endif
	
	#if 0
		//Test mat4 sub
	#endif
	
	__mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat2 = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat3 = { 2.f, 4.f, 6.f, 8.f, 10.f, 12.f , 14.f, 16.f, 18.f, 20.f, 22.f,24.f,26.f,28.f,30.f,32.f};

	#ifdef debug
	cout << "m: " << __mat << endl;
	cout << "m2: " << __mat2 << endl;
	cout << "m3: " << __mat3 << endl;
	#endif
	
	__mat3 = __mat2 - __mat;
	__mat2 -= __mat;
	
	#ifdef debug
	cout << "m2-m: " << __mat2 << endl;
	cout << "m2-=m: " << __mat3 << endl;
	#endif
	
	assert(__mat3 == __mat2);
	assert(__mat3 != __mat);
	
	__mat3 = __mat2 - 4.f;
	__mat2 -= 4.f;
	
	#ifdef debug
	cout << "m2+4: " << __mat2 << endl;
	cout << "m2+=4: " << __mat3 << endl;
	#endif
	
	#if 0
		//Test mat4 copy
	#endif
	
	__mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat2 = { 2.f, 3.f, 4.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 11.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat3 = __mat2;
	
	assert(__mat != __mat3);
	assert(__mat2 == __mat3);
	
	
	#if 0
		//Test mat4 mul
	#endif
	
	__mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat2 = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat3 = { 2.f, 4.f, 6.f, 8.f, 10.f, 12.f , 14.f, 16.f, 18.f, 20.f, 22.f,24.f,26.f,28.f,30.f,32.f};
	Mat4 __res = { 90.f, 100.f,110.f, 120.f, 202.f, 228.f, 254.f , 280.f, 314.f, 356.f, 398.f, 440.f, 426.f, 484.f, 542.f, 600.f};
	
	#ifdef debug
	cout << "m: " << __mat << endl;
	cout << "m2: " << __mat2 << endl;
	cout << "m3: " << __mat3 << endl;
	#endif
	
	__mat3 = __mat2 * __mat;
	__mat2 *= __mat;
	
	#ifdef debug
	cout << "m2*m: " << __mat2 << endl;
	cout << "m2*=m: " << __mat3 << endl;
	#endif
	
	assert(__mat3 == __res);
	assert(__mat2 == __res);
	assert(__mat3 == __mat2);
	assert(__mat3 != __mat);
	
	__mat3 = __mat2 * 4.f;
	__mat2 *= 4.f;
	
	#ifdef debug
	cout << "m2*4: " << __mat2 << endl;
	cout << "m2*=4: " << __mat3 << endl;
	#endif

	#if 0
		//Test mat4 transponse
	#endif
	
	__mat = { 1.f, 2.f, 3.f, 4.f, 5.f, 6.f , 7.f, 8.f, 9.f, 10.f, 11.f,12.f,13.f,14.f,15.f,16.f};
	__mat2 = { 1.f, 5.f, 9.f, 13.f, 2.f, 6.f , 10.f, 14.f, 3.f, 7.f, 11.f, 15.f, 4.f, 8.f, 12.f, 16.f};
	
	__mat.transponse();
	
	assert( __mat == __mat2 );
	
	#if 0
		//Test mat4 determinant
	#endif
	
	__mat = { 5.f, 0.f, 3.f, -1.f, 3.f, 0.f , 0.f, 4.f, -1.f, 2.f, 4.f, -2.f, 1.f, 0.f, 0.f, 5.f};
	assert(__mat.det() == 66.f);
	
	#if 0
		//Test mat4 inverse
	#endif
	__mat =  {1.f, 2.f, 3.f, 4.f, -1.f, 2.f, 0.f, 5.f, 0.f, 4.f, -2.f, 6.f, 2.f, 4.f, 0.f, 6.f };
	__mat2 = {1.f, 2.f, 3.f, 4.f, -1.f, 2.f, 0.f, 5.f, 0.f, 4.f, -2.f, 6.f, 2.f, 4.f, 0.f, 6.f };
	__mat3 = { 1.f, 0.f, 0.f, 0.f, 0.f, 1.f, 0.f, 0.f, 0.f, 0.f, 1.f, 0.f, 0.f, 0.f, 0.f, 1.f};
	
	#ifdef debug
	cout << "m: " << __mat << endl;
	#endif
	__mat.inverse();
	
	#ifdef debug
	cout << "m.inv: " << __mat << endl;
	#endif
	__mat *= __mat2;
	
	#ifdef debug
	cout << "m*m2: " << __mat << endl;
	#endif
	assert(__mat == __mat3);
	
	#ifdef debug
		cout << "End testing mat4:\n";
	#endif
	
	return 0;
}