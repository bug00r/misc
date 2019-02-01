#ifndef COLOR_H
#define COLOR_H

#include <iostream>

class Color {
	public:
		Color();
		Color(const float _r, const float _g, const float _b);
		Color(const Color &color);
		
		inline float get_r() const { return r; } 
		inline float get_g() const { return g; }
		inline float get_b() const { return b; }
		inline void set_r(const float val) { r=val; }
		inline void set_g(const float val) { g=val; }
		inline void set_b(const float val) { b=val; }
		
		bool operator==(const Color &color) const;
		bool operator!=(const Color &color) const;
		
		Color operator-()const;
		Color operator-(const Color &color) const;
		Color operator+(const Color &color) const;
		Color operator*(const Color &color) const;
		Color operator/(const Color &color) const;
		Color& operator=(const Color &color);
		Color& operator+=(const Color &color);
		Color& operator-=(const Color &color);
		Color& operator*=(const Color &color);
		Color& operator/=(const Color &color);
		Color operator-(const float &color) const;
		Color operator+(const float &color) const;
		Color operator*(const float &color) const;
		Color operator/(const float &color) const;
		Color& operator=(const float &color);
		Color& operator+=(const float &color);
		Color& operator-=(const float &color);
		Color& operator*=(const float &color);
		Color& operator/=(const float &color);
		
		void set_contrast(const float &contrast_factor);
		void set_brightness(const float &brightness);
		
		static float contrast_factor(const float &contrast);
	
	private:
		void truncate(float &value);
		void truncate_all();
		friend std::ostream & operator<<(std::ostream &os, const Color& c);
		float r,g,b;
};

#endif