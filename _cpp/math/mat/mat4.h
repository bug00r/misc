#if 0
/**
	This ist a 4x4 matrix.
*/
#endif

#ifndef MAT_4_H
#define MAT_4_H

#include <iostream>
using namespace std;

class Mat4 {
	
	public:
		enum rc {
			_11 = 0, _12 = 1, _13 = 2, _14 = 3,
			_21 = 4, _22 = 5, _23 = 6, _24 = 7,
			_31 = 8, _32 = 9, _33 = 10, _34 = 11,
			_41 = 12, _42 = 13, _43 = 14, _44 = 15,
		};
	
		Mat4();
		Mat4(const float __11, const float __12, const float __13, const float __14, 
			 const float __21, const float __22, const float __23, const float __24,
			 const float __31, const float __32, const float __33, const float __34,
			 const float __41, const float __42, const float __43, const float __44);
		Mat4(const Mat4 &m);
		
		float get(const rc &rc) const { return this->v[rc]; }
		void set(const rc &rc,const float _v) {this->v[rc] = _v; }
		
		bool 	operator==(const Mat4 &m) const;
		bool 	operator!=(const Mat4 &m) const;
		Mat4 	operator-()const;
		Mat4 	operator-(const Mat4 &m) const;
		Mat4 	operator+(const Mat4 &m) const;
		Mat4	operator*(const Mat4 &m) const;
		Mat4&	operator=(const Mat4 &m);
		Mat4&	operator+=(const Mat4 &m);
		Mat4&	operator-=(const Mat4 &m);
		Mat4& 	operator*=(const Mat4 &m);
		Mat4 	operator-(const float &m) const;
		Mat4 	operator+(const float &m) const;
		Mat4 	operator*(const float &m) const;
		Mat4& 	operator=(const float &m);
		Mat4& 	operator+=(const float &m);
		Mat4& 	operator-=(const float &m);
		Mat4& 	operator*=(const float &m);
		
		float det();
		void transponse();
		void inverse();
		
	private:
		friend std::ostream & operator<<(std::ostream &os, const Mat4& m);
		float v[16] ;
};
#endif