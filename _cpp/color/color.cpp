#include "color.h"


Color::Color(): r(0.f), g(0.f), b(0.f) {}
Color::Color(const float _r, const float _g, const float _b): r(_r), g(_g), b(_b) {}
Color::Color(const Color &color) {
	this->r = color.r;
	this->g = color.g;
	this->b = color.b;
}

std::ostream & operator<<(std::ostream &os, const Color& c)
{
	return os << "col[" << c.get_r() << "," << c.get_g() << "," << c.get_b() << "]";
}

Color& Color::operator=(const Color &color) {
	this->r = color.r;
	this->g = color.g;
	this->b = color.b;
	return *this;
}

Color& Color::operator+=(const Color &color) {
	this->r += color.r;
	this->g += color.g;
	this->b += color.b;
	return *this;
}
Color& Color::operator-=(const Color &color) {
	this->r -= color.r;
	this->g -= color.g;
	this->b -= color.b;
	return *this;
}
Color& Color::operator*=(const Color &color) {
	this->r *= color.r;
	this->g *= color.g;
	this->b *= color.b;
	return *this;
}
Color& Color::operator/=(const Color &color) {
	this->r /= color.r;
	this->g /= color.g;
	this->b /= color.b;
	return *this;
}

bool Color::operator==(const Color &color) const {
	return  ( this != nullptr) &&
			(this->r == color.r) &&
			(this->g == color.g) &&
			(this->b == color.b);
}
bool Color::operator!=(const Color &color) const {
	return !(this->operator==(color));
}
Color Color::operator-() const {
	return Color(-this->r, -this->g, -this->b);
}
Color Color::operator-(const Color &color) const {
	return Color(this->r - color.r, 
				 this->g - color.g,
				 this->b - color.b);
}
Color Color::operator+(const Color &color) const {
	return Color(this->r + color.r, 
				 this->g + color.g,
				 this->g + color.b);
}
Color Color::operator*(const Color &color) const {
	return Color(this->r * color.r, 
				 this->g * color.g,
				 this->b * color.b);
}
Color Color::operator/(const Color &color) const {
	return Color(this->r / color.r, 
				 this->g / color.g,
			     this->b / color.b);
}

Color Color::operator-(const float &color) const {
	return Color(this->r - color, 
				 this->g - color,
			     this->b - color);
}
Color Color::operator+(const float &color) const {
	return Color(this->r + color, 
				 this->g + color,
				 this->b + color);
}
Color Color::operator*(const float &color) const {
	return Color(this->r * color, 
				 this->g * color,
				 this->b * color);
}

Color Color::operator/(const float &color) const {
	return Color(this->r / color, 
				 this->g / color,
			     this->b / color);
}

Color& Color::operator=(const float &color) {
	this->r = color;
	this->g = color;
	this->b = color;
	return *this;
}

Color& Color::operator+=(const float &color) {
	this->r += color;
	this->g += color;
	this->b += color;
	return *this;
}
Color& Color::operator-=(const float &color) {
	this->r -= color;
	this->g -= color;
	this->b -= color;
	return *this;
}
Color& Color::operator*=(const float &color) {
	this->r *= color;
	this->g *= color;
	this->b *= color;
	return *this;
}
Color& Color::operator/=(const float &color) {
	this->r /= color;
	this->g /= color;
	this->b /= color;
	return *this;
}

void Color::truncate(float &value) {
	if ( value > 255.f ) value = 255.f;
	else if (value < 0.f) value = 0.f;
}

void Color::truncate_all() {
	this->truncate(this->r);
	this->truncate(this->g);
	this->truncate(this->b);
}

void Color::set_contrast(const float &contrast_factor) {
	this->r = (contrast_factor * (this->r - 128.f)) + 128.f;
	this->g = (contrast_factor * (this->g - 128.f)) + 128.f;
	this->b = (contrast_factor * (this->b - 128.f)) + 128.f;
	this->truncate_all();
}
		
float Color::contrast_factor(const float &contrast) {
	float usedcontrast = contrast;
	if(usedcontrast > 255.f) usedcontrast = 255.f;
	else if(usedcontrast < -255.f) usedcontrast = -255.f;
	return (259.f*(usedcontrast + 255.f)) / (255.f*(259.f - usedcontrast)) ; 
}

void Color::set_brightness(const float &brightness) {
	this->operator+=(brightness);
	this->truncate_all();
}
