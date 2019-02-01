#if 0
/**
	This ist a 2x2 matrix.
*/
#endif

#ifndef MAT_2_H
#define MAT_2_H

#include <iostream>
using namespace std;
	
class Mat2 {
	
	public:
		enum rc {
			_11 = 0,_12 = 1,_21 = 2,_22 = 3
		};
	
		Mat2();
		Mat2(const float __11,const float __12,const float __21,const float __22);
		Mat2(const Mat2 &m);
		
		float get(const rc &rc) const { return this->v[rc]; }
		void set(const rc &rc,const float _v) {this->v[rc] = _v; }
		
		bool 	operator==(const Mat2 &m) const;
		bool 	operator!=(const Mat2 &m) const;
		Mat2 	operator-()const;
		Mat2 	operator-(const Mat2 &m) const;
		Mat2 	operator+(const Mat2 &m) const;
		Mat2	operator*(const Mat2 &m) const;
		Mat2&	operator=(const Mat2 &m);
		Mat2&	operator+=(const Mat2 &m);
		Mat2&	operator-=(const Mat2 &m);
		Mat2& 	operator*=(const Mat2 &m);
		Mat2 	operator-(const float &m) const;
		Mat2 	operator+(const float &m) const;
		Mat2 	operator*(const float &m) const;
		Mat2& 	operator=(const float &m);
		Mat2& 	operator+=(const float &m);
		Mat2& 	operator-=(const float &m);
		Mat2& 	operator*=(const float &m);
		
		float det();
		void transponse();
		void inverse();
		
	private:
		friend std::ostream & operator<<(std::ostream &os, const Mat2& m);
		float v[4] ;
};

#endif