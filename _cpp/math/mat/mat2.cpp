Mat2::Mat2(): v{0.f} {}
Mat2::Mat2(const float __11,const float __12,const float __21,const float __22): v{__11, __12, __21, __22} {}
Mat2::Mat2(const Mat2 &m) {
	this->v[0] = m.get(Mat2::rc::_11);
	this->v[1] = m.get(Mat2::rc::_12);
	this->v[2] = m.get(Mat2::rc::_21);
	this->v[3] = m.get(Mat2::rc::_22);
}

std::ostream & operator<<(std::ostream &os, const Mat2& m)
{
	return os << "Mat2[" 
			  << m.get(Mat2::rc::_11) << "," << m.get(Mat2::rc::_12) << ','
			  << m.get(Mat2::rc::_21) << "," << m.get(Mat2::rc::_22) << "]";
}

bool 	Mat2::operator==(const Mat2 &m) const {
	return  ( this != nullptr) &&
			(this->v[Mat2::rc::_11] == m.get(Mat2::rc::_11)) &&
			(this->v[Mat2::rc::_12] == m.get(Mat2::rc::_12)) &&
			(this->v[Mat2::rc::_21] == m.get(Mat2::rc::_21)) &&
			(this->v[Mat2::rc::_22] == m.get(Mat2::rc::_22));
}
bool 	Mat2::operator!=(const Mat2 &m) const {
	return !(this->operator==(m));
}
Mat2 	Mat2::operator-()const {
	return Mat2(-this->v[Mat2::rc::_11],
	            -this->v[Mat2::rc::_12],
	            -this->v[Mat2::rc::_21],
	            -this->v[Mat2::rc::_22]);
	
}
Mat2 	Mat2::operator-(const Mat2 &m) const {
	return Mat2(this->v[Mat2::rc::_11] - m.get(Mat2::rc::_11),
	            this->v[Mat2::rc::_12] - m.get(Mat2::rc::_12),
	            this->v[Mat2::rc::_21] - m.get(Mat2::rc::_21),
	            this->v[Mat2::rc::_22] - m.get(Mat2::rc::_22));
}
Mat2 	Mat2::operator+(const Mat2 &m) const {
	return Mat2(this->v[Mat2::rc::_11] + m.get(Mat2::rc::_11),
	            this->v[Mat2::rc::_12] + m.get(Mat2::rc::_12),
	            this->v[Mat2::rc::_21] + m.get(Mat2::rc::_21),
	            this->v[Mat2::rc::_22] + m.get(Mat2::rc::_22));
}
Mat2	Mat2::operator*(const Mat2 &m) const {
	return Mat2(
		(this->v[Mat2::rc::_11] * m.get(Mat2::rc::_11)) + (this->v[Mat2::rc::_12] * m.get(Mat2::rc::_21)),
		(this->v[Mat2::rc::_11] * m.get(Mat2::rc::_12)) + (this->v[Mat2::rc::_12] * m.get(Mat2::rc::_22)),
		(this->v[Mat2::rc::_21] * m.get(Mat2::rc::_11)) + (this->v[Mat2::rc::_22] * m.get(Mat2::rc::_21)),
		(this->v[Mat2::rc::_21] * m.get(Mat2::rc::_12)) + (this->v[Mat2::rc::_22] * m.get(Mat2::rc::_22)));
}
Mat2&	Mat2::operator=(const Mat2 &m) {
	this->v[Mat2::rc::_11] = m.get(Mat2::rc::_11);
	this->v[Mat2::rc::_12] = m.get(Mat2::rc::_12);
	this->v[Mat2::rc::_21] = m.get(Mat2::rc::_21);
	this->v[Mat2::rc::_22] = m.get(Mat2::rc::_22);
	
	return *this;
}
Mat2&	Mat2::operator+=(const Mat2 &m) {
	this->v[Mat2::rc::_11] += m.get(Mat2::rc::_11);
	this->v[Mat2::rc::_12] += m.get(Mat2::rc::_12);
	this->v[Mat2::rc::_21] += m.get(Mat2::rc::_21);
	this->v[Mat2::rc::_22] += m.get(Mat2::rc::_22);
	return *this;
}
Mat2&	Mat2::operator-=(const Mat2 &m) {
	this->v[Mat2::rc::_11] -= m.get(Mat2::rc::_11);
	this->v[Mat2::rc::_12] -= m.get(Mat2::rc::_12);
	this->v[Mat2::rc::_21] -= m.get(Mat2::rc::_21);
	this->v[Mat2::rc::_22] -= m.get(Mat2::rc::_22);
	return *this;
}
Mat2&	Mat2::operator*=(const Mat2 &m) {
	Mat2 temp = *this * m;
	*this = temp;
	return *this;
}

Mat2 	Mat2::operator-(const float &m) const {
	return Mat2(this->v[Mat2::rc::_11] - m,
				this->v[Mat2::rc::_12] - m,
				this->v[Mat2::rc::_21] - m,
				this->v[Mat2::rc::_22] - m);
}
Mat2 	Mat2::operator+(const float &m) const {
	return Mat2(this->v[Mat2::rc::_11] + m,
				this->v[Mat2::rc::_12] + m,
				this->v[Mat2::rc::_21] + m,
				this->v[Mat2::rc::_22] + m);
}
Mat2 	Mat2::operator*(const float &m) const {
	return Mat2(this->v[Mat2::rc::_11] * m,
				this->v[Mat2::rc::_12] * m,
				this->v[Mat2::rc::_21] * m,
				this->v[Mat2::rc::_22] * m);
}
Mat2& 	Mat2::operator=(const float &m) {
	this->v[Mat2::rc::_11] = m;
	this->v[Mat2::rc::_12] = m;
	this->v[Mat2::rc::_21] = m;
	this->v[Mat2::rc::_22] = m;
	return *this;
}
Mat2& 	Mat2::operator+=(const float &m) {
	this->v[Mat2::rc::_11] += m;
	this->v[Mat2::rc::_12] += m;
	this->v[Mat2::rc::_21] += m;
	this->v[Mat2::rc::_22] += m;
	return *this;
}
Mat2& 	Mat2::operator-=(const float &m) {
	this->v[Mat2::rc::_11] -= m;
	this->v[Mat2::rc::_12] -= m;
	this->v[Mat2::rc::_21] -= m;
	this->v[Mat2::rc::_22] -= m;
	return *this;
}
Mat2& 	Mat2::operator*=(const float &m) {
	this->v[Mat2::rc::_11] *= m;
	this->v[Mat2::rc::_12] *= m;
	this->v[Mat2::rc::_21] *= m;
	this->v[Mat2::rc::_22] *= m;
	return *this;
}

float Mat2::det() {
	return (this->v[Mat2::rc::_11] * this->v[Mat2::rc::_22]) -
		   (this->v[Mat2::rc::_12] * this->v[Mat2::rc::_21]);
}
void Mat2::transponse() {
	float temp = this->v[Mat2::rc::_21];
	this->v[Mat2::rc::_21] = this->v[Mat2::rc::_12];
	this->v[Mat2::rc::_12] = temp;
}
void Mat2::inverse() {
	float t1 = this->v[Mat2::rc::_11], t3 = 1.f/this->det();
	this->v[Mat2::rc::_11] = this->v[Mat2::rc::_22];
	this->v[Mat2::rc::_22] = t1;
	t1 = this->v[Mat2::rc::_12];
	this->v[Mat2::rc::_12] = -this->v[Mat2::rc::_21];
	this->v[Mat2::rc::_21] = -t1;
	this->transponse();
	*this *= t3;
}
