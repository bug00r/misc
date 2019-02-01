#include "color.h"
#include <iostream>
using namespace std;

int main() {
	Color col = Color(1.f,2.f,3.f);
	Color col2 = Color(col);
	Color col3 = Color();
	Color col4 = col2;
	
	cout << "&==&: " << (&col == &col2) << 'n';
	cout << "&!=&: " << (&col != &col2) << '\n';
	cout << "-: " << -col << '\n';
	cout << "c+c2: " << (col+col2) << '\n';
	cout << "c-c2: " << (col-col2) << '\n';
	cout << "c/c2: " << (col/col2) << '\n';
	cout << "c*c2: " << (col*col2) << '\n';
	cout << "c!=c2: " << (col != col2) << '\n';
	cout << "c==c2: " << (col == col2) << '\n';
	cout << "c+=c2: " << (col += col2) << '\n';
	cout << "c!=c2: " << (col != col2) << '\n';
	cout << "c==c2: " << (col == col2) << '\n';
	cout << "c-=c2: " << (col -= col2) << '\n';
	cout << "c/=c2: " << (col /= col2) << '\n';
	cout << "c*=c2: " << (col *= col2) << '\n';
	cout << "skalar ops" << '\n';
	cout << "c: " << col << " c2: " << col2 << '\n';
	cout << "c+2: " << (col+2.f) << '\n';
	cout << "c-2: " << (col-2.f) << '\n';
	cout << "c/2: " << (col/2.f) << '\n';
	cout << "c*2: " << (col*2.f) << '\n';
	cout << "c: " << col << " c2: " << col2 << '\n';
	cout << "c+=2: " << (col += 2.f) << '\n';
	cout << "c-=2: " << (col -= 2.f) << '\n';
	cout << "c/=2: " << (col /= 2.f) << '\n';
	cout << "c*=2: " << (col *= 2.f) << '\n';
	cout << "c=5: " << (col = 5.f) << '\n';
	col.set_contrast(Color::contrast_factor(-80.f));
	cout << "c_contrast: " << col << '\n';
	col.set_brightness(30.f);
	cout << "c_brightness: " << col << '\n';
	cout << col2 << "\n" << col3 << "\n" << col4 << '\n';
	
	
	return 0;
}