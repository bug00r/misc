
Vec3::Vec3(): x(0.f), y(0.f), z(0.f) {}
Vec3::Vec3(const float _x, const float _y, const float _z): x(_x), y(_y), z(_z) {}
Vec3::Vec3(const Vec3 &vec) {
	this->x = vec.x;
	this->y = vec.y;
	this->z = vec.z;
}

std::ostream & operator<<(std::ostream &os, const Vec3& vec)
{
	return os << "Vec3[" << vec.get_x() << "," << vec.get_y() << "," << vec.get_z() << "]";
}

bool Vec3::operator==(const Vec3 &vec) const{
	return  ( this != nullptr) &&
			(this->x == vec.x) &&
			(this->y == vec.y) &&
			(this->z == vec.z);
}
bool Vec3::operator!=(const Vec3 &vec) const{
	return !(this->operator==(vec));
}

Vec3 Vec3::operator-()const{
	return Vec3(-this->x, -this->y, -this->z);
}
Vec3 Vec3::operator-(const Vec3 &vec) const{
	return Vec3(this->x - vec.x, this->y - vec.y, this->z - vec.z);
}
Vec3 Vec3::operator+(const Vec3 &vec) const{
	return Vec3(this->x + vec.x, this->y + vec.y, this->z + vec.z);
}
float Vec3::operator*(const Vec3 &vec) const{
	return ((this->x * vec.x)+(this->y * vec.y)+(this->z * vec.z));
}
Vec3& Vec3::operator=(const Vec3 &vec){
	this->x = vec.x;
	this->y = vec.y;
	this->z = vec.z;
	return *this;
}
Vec3& Vec3::operator+=(const Vec3 &vec){
	this->x += vec.x;
	this->y += vec.y;
	this->z += vec.z;
	return *this;
}
Vec3& Vec3::operator-=(const Vec3 &vec){
	this->x -= vec.x;
	this->y -= vec.y;
	this->z -= vec.z;
	return *this;
}
Vec3 Vec3::operator-(const float &vec) const{
	return Vec3(this->x - vec, this->y - vec, this->z - vec);
}
Vec3 Vec3::operator+(const float &vec) const{
	return Vec3(this->x + vec, this->y + vec, this->z + vec);
}
Vec3 Vec3::operator*(const float &vec) const{
	return Vec3(this->x * vec, this->y * vec, this->z * vec);
}
Vec3 Vec3::operator/(const float &vec) const{
	return Vec3(this->x / vec, this->y / vec, this->z / vec);
}
Vec3& Vec3::operator=(const float &vec){
	this->x = vec;
	this->y = vec;
	this->z = vec;
	return *this;
}
Vec3& Vec3::operator+=(const float &vec){
	this->x += vec;
	this->y += vec;
	this->z += vec;
	return *this;
}
Vec3& Vec3::operator-=(const float &vec){
	this->x -= vec;
	this->y -= vec;
	this->z -= vec;
	return *this;
}
Vec3& Vec3::operator*=(const float &vec){
	this->x *= vec;
	this->y *= vec;
	this->z *= vec;
	return *this;
}
Vec3& Vec3::operator/=(const float &vec){
	this->x /= vec;
	this->y /= vec;
	this->z /= vec;
	return *this;
}

Vec3& 	operator*=(Vec3 &v, const Mat3 &m){
	Vec3 temp = v;
	v.set_x((m.get(Mat3::rc::_11) * temp.get_x()) + (m.get(Mat3::rc::_12) * temp.get_y()) + (m.get(Mat3::rc::_13) * temp.get_z()));
	v.set_y((m.get(Mat3::rc::_21) * temp.get_x()) + (m.get(Mat3::rc::_22) * temp.get_y()) + (m.get(Mat3::rc::_23) * temp.get_z()));
	v.set_z((m.get(Mat3::rc::_31) * temp.get_x()) + (m.get(Mat3::rc::_32) * temp.get_y()) + (m.get(Mat3::rc::_33) * temp.get_z()));
	return v;
}

Vec3	operator*(const Vec3 &v, const Mat3 &m){
	Vec3 nv = v;
	nv *= m;
	return nv;
}

Vec3 Vec3::cross( const Vec3 &v) { 
	return {
		((this->y * v.z) - (this->z * v.y)),
		((this->z * v.x) - (this->x * v.z)),
		((this->x * v.y) - (this->y * v.x))
	};
}
bool Vec3::isorthogonal(const Vec3 &v) { 
	return ((*this * v)  == 0.f);
}
float Vec3::length(){ 
	return sqrt((this->x*this->x) + (this->y*this->y) + (this->z*this->z)); 
}
void Vec3::norm(){
	*this *= (1.0f/this->length()); 
}
float Vec3::angle( Vec3 &v){ 
	return acos( *this * v / ( this->length() * v.length() )); 
}

float Vec3::spat(Vec3 &v, Vec3 &v1) {
	return ( this->cross(v) * v1 );
}

void Vec3::scale(const float &scx, const float &scy, const float &scz) {
	this->x *= scx;
	this->y *= scy;
	this->z *= scz;
}

float Vec3::place(const Vec3 &s, const Vec3 &e){	
	return (this->x - s.get_x()) * (e.get_y() - s.get_y()) - (this->y - s.get_y()) * (e.get_x() - s.get_x());
	#if 0
	Mat2 temp = { (this->x - s.get_x()), (this->y - s.get_y()), (e.get_x() - s.get_x()),(e.get_y() - s.get_y())};
	return temp.det();
	#endif
}

float Vec3::transform(const Mat4 &m) {
	const float x = this->x, y = this->y, z = this->z;
	this->x = (x * m.get(Mat4::rc::_11)) + (y * m.get(Mat4::rc::_12)) + (z * m.get(Mat4::rc::_13)) + m.get(Mat4::rc::_14);
	this->y = (x * m.get(Mat4::rc::_21)) + (y * m.get(Mat4::rc::_22)) + (z * m.get(Mat4::rc::_23)) + m.get(Mat4::rc::_24);
	this->z = (x * m.get(Mat4::rc::_31)) + (y * m.get(Mat4::rc::_32)) + (z * m.get(Mat4::rc::_33)) + m.get(Mat4::rc::_34);

	float weight = (x * m.get(Mat4::rc::_41)) + (y * m.get(Mat4::rc::_42)) + (z * m.get(Mat4::rc::_43)) + m.get(Mat4::rc::_44);
	
	if (weight != 1.f && weight != 0.f){
		*this /= weight;
	}
	return weight;
	
	//	vec3_t temp = {
	//	(v->x * m->_11) + (v->y * m->_12) + (v->z * m->_13) + m->_14,
	//	(v->x * m->_21) + (v->y * m->_22) + (v->z * m->_23) + m->_24,
	//	(v->x * m->_31) + (v->y * m->_32) + (v->z * m->_33) + m->_34
	//};
	//float weight = (v->x * m->_41) + (v->y * m->_42) + (v->z * m->_43) + m->_44;
	//if (weight != 1.f && weight != 0.f){
	//	temp.x /= weight;
	//	temp.y /= weight;
	//	temp.z /= weight;
	//}
	//v->x = temp.x;
	//v->y = temp.y;
	//v->z = temp.z;
	//return weight;
	
}


