Mat3::Mat3(): v{0.f} {}
Mat3::Mat3(const float __11, const float __12, const float __13, 
		   const float __21, const float __22, const float __23,
		   const float __31, const float __32, const float __33): 
		   v{__11, __12, __13, __21, __22, __23, __31, __32, __33} {}
Mat3::Mat3(const Mat3 &m) {
	this->v[0] = m.get(Mat3::rc::_11);
	this->v[1] = m.get(Mat3::rc::_12);
	this->v[2] = m.get(Mat3::rc::_13);
	this->v[3] = m.get(Mat3::rc::_21);
	this->v[4] = m.get(Mat3::rc::_22);
	this->v[5] = m.get(Mat3::rc::_23);
	this->v[6] = m.get(Mat3::rc::_31);
	this->v[7] = m.get(Mat3::rc::_32);
	this->v[8] = m.get(Mat3::rc::_33);
}

std::ostream & operator<<(std::ostream &os, const Mat3& m)
{
	return os << "Mat3[" 
			  << m.get(Mat3::rc::_11) << "," << m.get(Mat3::rc::_12) << ',' << m.get(Mat3::rc::_13) << ','
			  << m.get(Mat3::rc::_21) << "," << m.get(Mat3::rc::_22) << ',' << m.get(Mat3::rc::_23) << ','
			  << m.get(Mat3::rc::_31) << "," << m.get(Mat3::rc::_32) << ',' << m.get(Mat3::rc::_33) << "]";
}

bool 	Mat3::operator==(const Mat3 &m) const {
	return  ( this != nullptr) &&
			(this->v[Mat3::rc::_11] == m.get(Mat3::rc::_11)) &&
			(this->v[Mat3::rc::_12] == m.get(Mat3::rc::_12)) &&
			(this->v[Mat3::rc::_13] == m.get(Mat3::rc::_13)) &&
			(this->v[Mat3::rc::_21] == m.get(Mat3::rc::_21)) &&
			(this->v[Mat3::rc::_22] == m.get(Mat3::rc::_22)) &&
			(this->v[Mat3::rc::_23] == m.get(Mat3::rc::_23)) &&
			(this->v[Mat3::rc::_31] == m.get(Mat3::rc::_31)) &&
			(this->v[Mat3::rc::_32] == m.get(Mat3::rc::_32)) &&
			(this->v[Mat3::rc::_33] == m.get(Mat3::rc::_33));
}
bool 	Mat3::operator!=(const Mat3 &m) const {
	return !(this->operator==(m));
}
Mat3 	Mat3::operator-()const {
	return Mat3(-this->v[Mat3::rc::_11],
	            -this->v[Mat3::rc::_12],
				-this->v[Mat3::rc::_13],
	            -this->v[Mat3::rc::_21],
	            -this->v[Mat3::rc::_22],
				-this->v[Mat3::rc::_23],
				-this->v[Mat3::rc::_31],
	            -this->v[Mat3::rc::_32],
				-this->v[Mat3::rc::_33]);
	
}
Mat3 	Mat3::operator-(const Mat3 &m) const {
	return Mat3(this->v[Mat3::rc::_11] - m.get(Mat3::rc::_11),
	            this->v[Mat3::rc::_12] - m.get(Mat3::rc::_12),
				this->v[Mat3::rc::_13] - m.get(Mat3::rc::_13),
	            this->v[Mat3::rc::_21] - m.get(Mat3::rc::_21),
	            this->v[Mat3::rc::_22] - m.get(Mat3::rc::_22),
				this->v[Mat3::rc::_23] - m.get(Mat3::rc::_23),
				this->v[Mat3::rc::_31] - m.get(Mat3::rc::_31),
	            this->v[Mat3::rc::_32] - m.get(Mat3::rc::_32),
				this->v[Mat3::rc::_33] - m.get(Mat3::rc::_33));
}
Mat3 	Mat3::operator+(const Mat3 &m) const {
	return Mat3(this->v[Mat3::rc::_11] + m.get(Mat3::rc::_11),
	            this->v[Mat3::rc::_12] + m.get(Mat3::rc::_12),
				this->v[Mat3::rc::_13] + m.get(Mat3::rc::_13),
	            this->v[Mat3::rc::_21] + m.get(Mat3::rc::_21),
	            this->v[Mat3::rc::_22] + m.get(Mat3::rc::_22),
				this->v[Mat3::rc::_23] + m.get(Mat3::rc::_23),
				this->v[Mat3::rc::_31] + m.get(Mat3::rc::_31),
	            this->v[Mat3::rc::_32] + m.get(Mat3::rc::_32),
				this->v[Mat3::rc::_33] + m.get(Mat3::rc::_33));
}
Mat3	Mat3::operator*(const Mat3 &m) const {
	return Mat3(
		(this->v[Mat3::rc::_11] * m.get(Mat3::rc::_11)) + (this->v[Mat3::rc::_12] * m.get(Mat3::rc::_21)) + (this->v[Mat3::rc::_13] * m.get(Mat3::rc::_31)),
		(this->v[Mat3::rc::_11] * m.get(Mat3::rc::_12)) + (this->v[Mat3::rc::_12] * m.get(Mat3::rc::_22)) + (this->v[Mat3::rc::_13] * m.get(Mat3::rc::_32)),
		(this->v[Mat3::rc::_11] * m.get(Mat3::rc::_13)) + (this->v[Mat3::rc::_12] * m.get(Mat3::rc::_23)) + (this->v[Mat3::rc::_13] * m.get(Mat3::rc::_33)),
		(this->v[Mat3::rc::_21] * m.get(Mat3::rc::_11)) + (this->v[Mat3::rc::_22] * m.get(Mat3::rc::_21)) + (this->v[Mat3::rc::_23] * m.get(Mat3::rc::_31)),
		(this->v[Mat3::rc::_21] * m.get(Mat3::rc::_12)) + (this->v[Mat3::rc::_22] * m.get(Mat3::rc::_22)) + (this->v[Mat3::rc::_23] * m.get(Mat3::rc::_32)),
		(this->v[Mat3::rc::_21] * m.get(Mat3::rc::_13)) + (this->v[Mat3::rc::_22] * m.get(Mat3::rc::_23)) + (this->v[Mat3::rc::_23] * m.get(Mat3::rc::_33)),
		(this->v[Mat3::rc::_31] * m.get(Mat3::rc::_11)) + (this->v[Mat3::rc::_32] * m.get(Mat3::rc::_21)) + (this->v[Mat3::rc::_33] * m.get(Mat3::rc::_31)),
		(this->v[Mat3::rc::_31] * m.get(Mat3::rc::_12)) + (this->v[Mat3::rc::_32] * m.get(Mat3::rc::_22)) + (this->v[Mat3::rc::_33] * m.get(Mat3::rc::_32)),
		(this->v[Mat3::rc::_31] * m.get(Mat3::rc::_13)) + (this->v[Mat3::rc::_32] * m.get(Mat3::rc::_23)) + (this->v[Mat3::rc::_33] * m.get(Mat3::rc::_33)));

}

Mat3&	Mat3::operator=(const Mat3 &m) {
	this->v[Mat3::rc::_11] = m.get(Mat3::rc::_11);
	this->v[Mat3::rc::_12] = m.get(Mat3::rc::_12);
	this->v[Mat3::rc::_13] = m.get(Mat3::rc::_13);
	this->v[Mat3::rc::_21] = m.get(Mat3::rc::_21);
	this->v[Mat3::rc::_22] = m.get(Mat3::rc::_22);
	this->v[Mat3::rc::_23] = m.get(Mat3::rc::_23);
	this->v[Mat3::rc::_31] = m.get(Mat3::rc::_31);
	this->v[Mat3::rc::_32] = m.get(Mat3::rc::_32);
	this->v[Mat3::rc::_33] = m.get(Mat3::rc::_33);
	return *this;
}
Mat3&	Mat3::operator+=(const Mat3 &m) {
	this->v[Mat3::rc::_11] += m.get(Mat3::rc::_11);
	this->v[Mat3::rc::_12] += m.get(Mat3::rc::_12);
	this->v[Mat3::rc::_13] += m.get(Mat3::rc::_13);
	this->v[Mat3::rc::_21] += m.get(Mat3::rc::_21);
	this->v[Mat3::rc::_22] += m.get(Mat3::rc::_22);
	this->v[Mat3::rc::_23] += m.get(Mat3::rc::_23);
	this->v[Mat3::rc::_31] += m.get(Mat3::rc::_31);
	this->v[Mat3::rc::_32] += m.get(Mat3::rc::_32);
	this->v[Mat3::rc::_33] += m.get(Mat3::rc::_33);
	return *this;
}

Mat3&	Mat3::operator-=(const Mat3 &m) {
	this->v[Mat3::rc::_11] -= m.get(Mat3::rc::_11);
	this->v[Mat3::rc::_12] -= m.get(Mat3::rc::_12);
	this->v[Mat3::rc::_13] -= m.get(Mat3::rc::_13);
	this->v[Mat3::rc::_21] -= m.get(Mat3::rc::_21);
	this->v[Mat3::rc::_22] -= m.get(Mat3::rc::_22);
	this->v[Mat3::rc::_23] -= m.get(Mat3::rc::_23);
	this->v[Mat3::rc::_31] -= m.get(Mat3::rc::_31);
	this->v[Mat3::rc::_32] -= m.get(Mat3::rc::_32);
	this->v[Mat3::rc::_33] -= m.get(Mat3::rc::_33);
	return *this;
}
Mat3&	Mat3::operator*=(const Mat3 &m) {
	Mat3 temp = *this * m;
	*this = temp;
	return *this;
}

Mat3 	Mat3::operator-(const float &m) const {
	return Mat3(this->v[Mat3::rc::_11] - m,
				this->v[Mat3::rc::_12] - m,
				this->v[Mat3::rc::_13] - m,
				this->v[Mat3::rc::_21] - m,
				this->v[Mat3::rc::_22] - m,
				this->v[Mat3::rc::_23] - m,
				this->v[Mat3::rc::_31] - m,
				this->v[Mat3::rc::_32] - m,
				this->v[Mat3::rc::_33] - m);
}
Mat3 	Mat3::operator+(const float &m) const {
	return Mat3(this->v[Mat3::rc::_11] + m,
				this->v[Mat3::rc::_12] + m,
				this->v[Mat3::rc::_13] + m,
				this->v[Mat3::rc::_21] + m,
				this->v[Mat3::rc::_22] + m,
				this->v[Mat3::rc::_23] + m,
				this->v[Mat3::rc::_31] + m,
				this->v[Mat3::rc::_32] + m,
				this->v[Mat3::rc::_33] + m);
}
Mat3 	Mat3::operator*(const float &m) const {
	return Mat3(this->v[Mat3::rc::_11] * m,
				this->v[Mat3::rc::_12] * m,
				this->v[Mat3::rc::_13] * m,
				this->v[Mat3::rc::_21] * m,
				this->v[Mat3::rc::_22] * m,
				this->v[Mat3::rc::_23] * m,
				this->v[Mat3::rc::_31] * m,
				this->v[Mat3::rc::_32] * m,
				this->v[Mat3::rc::_33] * m);
}
Mat3& 	Mat3::operator=(const float &m) {
	this->v[Mat3::rc::_11] = m;
	this->v[Mat3::rc::_12] = m;
	this->v[Mat3::rc::_13] = m;
	this->v[Mat3::rc::_21] = m;
	this->v[Mat3::rc::_22] = m;
	this->v[Mat3::rc::_23] = m;
	this->v[Mat3::rc::_31] = m;
	this->v[Mat3::rc::_32] = m;
	this->v[Mat3::rc::_33] = m;
	return *this;
}
Mat3& 	Mat3::operator+=(const float &m) {
	this->v[Mat3::rc::_11] += m;
	this->v[Mat3::rc::_12] += m;
	this->v[Mat3::rc::_13] += m;
	this->v[Mat3::rc::_21] += m;
	this->v[Mat3::rc::_22] += m;
	this->v[Mat3::rc::_23] += m;
	this->v[Mat3::rc::_31] += m;
	this->v[Mat3::rc::_32] += m;
	this->v[Mat3::rc::_33] += m;
	return *this;
}
Mat3& 	Mat3::operator-=(const float &m) {
	this->v[Mat3::rc::_11] -= m;
	this->v[Mat3::rc::_12] -= m;
	this->v[Mat3::rc::_13] -= m;
	this->v[Mat3::rc::_21] -= m;
	this->v[Mat3::rc::_22] -= m;
	this->v[Mat3::rc::_23] -= m;
	this->v[Mat3::rc::_31] -= m;
	this->v[Mat3::rc::_32] -= m;
	this->v[Mat3::rc::_33] -= m;
	return *this;
}
Mat3& 	Mat3::operator*=(const float &m) {
	this->v[Mat3::rc::_11] *= m;
	this->v[Mat3::rc::_12] *= m;
	this->v[Mat3::rc::_13] *= m;
	this->v[Mat3::rc::_21] *= m;
	this->v[Mat3::rc::_22] *= m;
	this->v[Mat3::rc::_23] *= m;
	this->v[Mat3::rc::_31] *= m;
	this->v[Mat3::rc::_32] *= m;
	this->v[Mat3::rc::_33] *= m;
	return *this;
}

float Mat3::det() {
	float result = 0.f, temp;
	temp = this->v[Mat3::rc::_11];
	temp *= this->v[Mat3::rc::_22];
	temp *= this->v[Mat3::rc::_33];	
	result = temp;
	temp  = this->v[Mat3::rc::_12];
	temp *= this->v[Mat3::rc::_23];
	temp *= this->v[Mat3::rc::_31];
	result += temp;
	temp  = this->v[Mat3::rc::_13];
	temp *= this->v[Mat3::rc::_21];
	temp *= this->v[Mat3::rc::_32];
	result += temp;
	temp  = this->v[Mat3::rc::_13];
	temp *= this->v[Mat3::rc::_22];
	temp *= this->v[Mat3::rc::_31];
	result -= temp;
	temp  = this->v[Mat3::rc::_12];
	temp *= this->v[Mat3::rc::_21];
	temp *= this->v[Mat3::rc::_33];
	result -= temp;
	temp  = this->v[Mat3::rc::_11];
	temp *= this->v[Mat3::rc::_23];
	temp *= this->v[Mat3::rc::_32];
	result -= temp;
	return result;

}
void Mat3::transponse() {
	float temp = this->v[Mat3::rc::_21];
	this->v[Mat3::rc::_21] = this->v[Mat3::rc::_12];
	this->v[Mat3::rc::_12] = temp;
	temp = this->v[Mat3::rc::_31];
	this->v[Mat3::rc::_31] = this->v[Mat3::rc::_13];
	this->v[Mat3::rc::_13] = temp;
	temp = this->v[Mat3::rc::_32];
	this->v[Mat3::rc::_32] = this->v[Mat3::rc::_23];
	this->v[Mat3::rc::_23] = temp;
}

void Mat3::inverse() {	
	Mat2 temp;
	Mat3 that = *this;
	float factor = (1.f/this->det());
	temp = { that.get(Mat3::rc::_22), that.get(Mat3::rc::_23), that.get(Mat3::rc::_32), that.get(Mat3::rc::_33)};
	this->v[Mat3::rc::_11] = temp.det();
	temp = { that.get(Mat3::rc::_21), that.get(Mat3::rc::_23), that.get(Mat3::rc::_31), that.get(Mat3::rc::_33)};
	this->v[Mat3::rc::_12] = -temp.det();
	temp = { that.get(Mat3::rc::_21), that.get(Mat3::rc::_22), that.get(Mat3::rc::_31), that.get(Mat3::rc::_32)};
	this->v[Mat3::rc::_13] = temp.det();
	
	temp = { that.get(Mat3::rc::_12), that.get(Mat3::rc::_13), that.get(Mat3::rc::_32), that.get(Mat3::rc::_33)};
	this->v[Mat3::rc::_21] = -temp.det();
	temp = { that.get(Mat3::rc::_11), that.get(Mat3::rc::_13), that.get(Mat3::rc::_31), that.get(Mat3::rc::_33) };
	this->v[Mat3::rc::_22] = temp.det();
	temp = { that.get(Mat3::rc::_11), that.get(Mat3::rc::_12), that.get(Mat3::rc::_31), that.get(Mat3::rc::_32)};
	this->v[Mat3::rc::_23] = -temp.det();
	
	temp = { that.get(Mat3::rc::_12), that.get(Mat3::rc::_13), that.get(Mat3::rc::_22), that.get(Mat3::rc::_23)};
	this->v[Mat3::rc::_31] = temp.det();
	temp = { that.get(Mat3::rc::_11), that.get(Mat3::rc::_13), that.get(Mat3::rc::_21), that.get(Mat3::rc::_23)};
	this->v[Mat3::rc::_32] = -temp.det();
	temp = { that.get(Mat3::rc::_11), that.get(Mat3::rc::_12), that.get(Mat3::rc::_21), that.get(Mat3::rc::_22)};
	this->v[Mat3::rc::_33] = temp.det();
	
	this->transponse();
	
	*this *= factor;
}

Mat3 Mat3::create_rot_x_mat(const float &degree){
	const float radian = Mat3::onedegrad*degree;
	const float sinus = sinf(radian);
	const float cosinus = cosf(radian);
	return Mat3(1.f, 0.f, 0.f, 0.f, cosinus, -sinus, 0.f, sinus, cosinus);
 
}

Mat3 Mat3::create_rot_y_mat(const float &degree){
	const float radian = Mat3::onedegrad*degree;
	const float sinus = sinf(radian);
	const float cosinus = cosf(radian);
	return Mat3(cosinus, 0.f, sinus, 0.f, 1.f, 0.f, -sinus, 0.f, cosinus);
}

Mat3 Mat3::create_rot_z_mat(const float &degree){
	const float radian = Mat3::onedegrad*degree;
	const float sinus = sinf(radian);
	const float cosinus = cosf(radian);
	return Mat3(cosinus, -sinus, 0.f, sinus, cosinus, 0.f, 0.f, 0.f, 1.f);
}
