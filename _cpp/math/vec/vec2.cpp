Vec2::Vec2(): x(0.f), y(0.f) {}
Vec2::Vec2(const float _x, const float _y): x(_x), y(_y) {}
Vec2::Vec2(const Vec2 &vec) {
	this->x = vec.x;
	this->y = vec.y;
}

std::ostream & operator<<(std::ostream &os, const Vec2& vec)
{
	return os << "vec2[" << vec.get_x() << "," << vec.get_y() << "]";
}

bool Vec2::operator==(const Vec2 &vec) const{
	return  ( this != nullptr) &&
			(this->x == vec.x) &&
			(this->y == vec.y);
}
bool Vec2::operator!=(const Vec2 &vec) const{
	return !(this->operator==(vec));
}

Vec2 Vec2::operator-()const{
	return Vec2(-this->x, -this->y);
}
Vec2 Vec2::operator-(const Vec2 &vec) const{
	return Vec2(this->x - vec.x, this->y - vec.y);
}
Vec2 Vec2::operator+(const Vec2 &vec) const{
	return Vec2(this->x + vec.x, this->y + vec.y);
}
float Vec2::operator*(const Vec2 &vec) const{
	return ((this->x * vec.x)+(this->y * vec.y));
}
Vec2& Vec2::operator=(const Vec2 &vec){
	this->x = vec.x;
	this->y = vec.y;
	return *this;
}
Vec2& Vec2::operator+=(const Vec2 &vec){
	this->x += vec.x;
	this->y += vec.y;
	return *this;
}
Vec2& Vec2::operator-=(const Vec2 &vec){
	this->x -= vec.x;
	this->y -= vec.y;
	return *this;
}
Vec2 Vec2::operator-(const float &vec) const{
	return Vec2(this->x - vec, this->y - vec);
}
Vec2 Vec2::operator+(const float &vec) const{
	return Vec2(this->x + vec, this->y + vec);
}
Vec2 Vec2::operator*(const float &vec) const{
	return Vec2(this->x * vec, this->y * vec);
}
Vec2 Vec2::operator/(const float &vec) const{
	return Vec2(this->x / vec, this->y / vec);
}
Vec2& Vec2::operator=(const float &vec){
	this->x = vec;
	this->y = vec;
	return *this;
}
Vec2& Vec2::operator+=(const float &vec){
	this->x += vec;
	this->y += vec;
	return *this;
}
Vec2& Vec2::operator-=(const float &vec){
	this->x -= vec;
	this->y -= vec;
	return *this;
}
Vec2& Vec2::operator*=(const float &vec){
	this->x *= vec;
	this->y *= vec;
	return *this;
}
Vec2& Vec2::operator/=(const float &vec){
	this->x /= vec;
	this->y /= vec;
	return *this;
}

Vec2& 	operator*=(Vec2 &v, const Mat2 &m){
	Vec2 temp = v;
	v.set_x((m.get(Mat2::rc::_11) * temp.get_x()) + (m.get(Mat2::rc::_12) * temp.get_y()));
	v.set_y((m.get(Mat2::rc::_21) * temp.get_x()) + (m.get(Mat2::rc::_22) * temp.get_y()));
	return v;
}
Vec2	operator*(const Vec2 &v, const Mat2 &m){
	Vec2 nv = v;
	nv *= m;
	return nv;
}

float Vec2::cross( const Vec2 &v) { 
	return (this->x * v.y) - (v.x*this->y); 
}
bool Vec2::isorthogonal(const Vec2 &v) { 
	return ((*this * v)  == 0.f);
}
float Vec2::length(){ 
	return sqrt((this->x*this->x) + (this->y*this->y)); 
}
void Vec2::norm(){
	*this *= (1.0f/this->length()); 
}
float Vec2::angle( Vec2 &v){ 
	return acos( *this * v / ( this->length() * v.length() )); 
}
