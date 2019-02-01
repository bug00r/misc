Mat4::Mat4(): v{0.f} {}
Mat4::Mat4(const float __11, const float __12, const float __13, const float __14, 
		   const float __21, const float __22, const float __23, const float __24,
		   const float __31, const float __32, const float __33, const float __34,
		   const float __41, const float __42, const float __43, const float __44): 
		   v{__11, __12, __13, __14, __21, __22, __23, __24, __31, __32, __33, __34, __41, __42, __43, __44} {}
Mat4::Mat4(const Mat4 &m) {
	this->v[0] = m.get(Mat4::rc::_11);
	this->v[1] = m.get(Mat4::rc::_12);
	this->v[2] = m.get(Mat4::rc::_13);
	this->v[3] = m.get(Mat4::rc::_14);
	this->v[4] = m.get(Mat4::rc::_21);
	this->v[5] = m.get(Mat4::rc::_22);
	this->v[6] = m.get(Mat4::rc::_23);
	this->v[7] = m.get(Mat4::rc::_24);
	this->v[8] = m.get(Mat4::rc::_31);
	this->v[9] = m.get(Mat4::rc::_32);
	this->v[10] = m.get(Mat4::rc::_33);
	this->v[11] = m.get(Mat4::rc::_34);
	this->v[12] = m.get(Mat4::rc::_41);
	this->v[13] = m.get(Mat4::rc::_42);
	this->v[14] = m.get(Mat4::rc::_43);
	this->v[15] = m.get(Mat4::rc::_44);
}

std::ostream & operator<<(std::ostream &os, const Mat4& m)
{
	return os << "Mat4[" 
			  << m.get(Mat4::rc::_11) << "," << m.get(Mat4::rc::_12) << ',' << m.get(Mat4::rc::_13) << ',' << m.get(Mat4::rc::_14) << ','
			  << m.get(Mat4::rc::_21) << "," << m.get(Mat4::rc::_22) << ',' << m.get(Mat4::rc::_23) << ',' << m.get(Mat4::rc::_24) << ','
			  << m.get(Mat4::rc::_31) << "," << m.get(Mat4::rc::_32) << ',' << m.get(Mat4::rc::_33) << ',' << m.get(Mat4::rc::_34) << ','
			  << m.get(Mat4::rc::_41) << "," << m.get(Mat4::rc::_42) << ',' << m.get(Mat4::rc::_43) << ',' << m.get(Mat4::rc::_44) << "]";
}

bool 	Mat4::operator==(const Mat4 &m) const {
	return  ( this != nullptr) &&
			(this->v[Mat4::rc::_11] == m.get(Mat4::rc::_11)) &&
			(this->v[Mat4::rc::_12] == m.get(Mat4::rc::_12)) &&
			(this->v[Mat4::rc::_13] == m.get(Mat4::rc::_13)) &&
			(this->v[Mat4::rc::_14] == m.get(Mat4::rc::_14)) &&
			(this->v[Mat4::rc::_21] == m.get(Mat4::rc::_21)) &&
			(this->v[Mat4::rc::_22] == m.get(Mat4::rc::_22)) &&
			(this->v[Mat4::rc::_23] == m.get(Mat4::rc::_23)) &&
			(this->v[Mat4::rc::_24] == m.get(Mat4::rc::_24)) &&
			(this->v[Mat4::rc::_31] == m.get(Mat4::rc::_31)) &&
			(this->v[Mat4::rc::_32] == m.get(Mat4::rc::_32)) &&
			(this->v[Mat4::rc::_33] == m.get(Mat4::rc::_33)) &&
			(this->v[Mat4::rc::_34] == m.get(Mat4::rc::_34)) &&
			(this->v[Mat4::rc::_41] == m.get(Mat4::rc::_41)) &&
			(this->v[Mat4::rc::_42] == m.get(Mat4::rc::_42)) &&
			(this->v[Mat4::rc::_43] == m.get(Mat4::rc::_43)) &&
			(this->v[Mat4::rc::_44] == m.get(Mat4::rc::_44));
}
bool 	Mat4::operator!=(const Mat4 &m) const {
	return !(this->operator==(m));
}

Mat4 	Mat4::operator-()const {
	return Mat4(-this->v[Mat4::rc::_11],
	            -this->v[Mat4::rc::_12],
				-this->v[Mat4::rc::_13],
				-this->v[Mat4::rc::_14],
	            -this->v[Mat4::rc::_21],
	            -this->v[Mat4::rc::_22],
				-this->v[Mat4::rc::_23],
				-this->v[Mat4::rc::_24],
				-this->v[Mat4::rc::_31],
	            -this->v[Mat4::rc::_32],
				-this->v[Mat4::rc::_33],
				-this->v[Mat4::rc::_34],
				-this->v[Mat4::rc::_41],
	            -this->v[Mat4::rc::_42],
				-this->v[Mat4::rc::_43],
				-this->v[Mat4::rc::_44]);
	
}
Mat4 	Mat4::operator-(const Mat4 &m) const {
	return Mat4(this->v[Mat4::rc::_11] - m.get(Mat4::rc::_11),
	            this->v[Mat4::rc::_12] - m.get(Mat4::rc::_12),
				this->v[Mat4::rc::_13] - m.get(Mat4::rc::_13),
				this->v[Mat4::rc::_14] - m.get(Mat4::rc::_14),
	            this->v[Mat4::rc::_21] - m.get(Mat4::rc::_21),
	            this->v[Mat4::rc::_22] - m.get(Mat4::rc::_22),
				this->v[Mat4::rc::_23] - m.get(Mat4::rc::_23),
				this->v[Mat4::rc::_24] - m.get(Mat4::rc::_24),
				this->v[Mat4::rc::_31] - m.get(Mat4::rc::_31),
	            this->v[Mat4::rc::_32] - m.get(Mat4::rc::_32),
				this->v[Mat4::rc::_33] - m.get(Mat4::rc::_33),
				this->v[Mat4::rc::_34] - m.get(Mat4::rc::_34),
				this->v[Mat4::rc::_41] - m.get(Mat4::rc::_41),
	            this->v[Mat4::rc::_42] - m.get(Mat4::rc::_42),
				this->v[Mat4::rc::_43] - m.get(Mat4::rc::_43),
				this->v[Mat4::rc::_44] - m.get(Mat4::rc::_44));
}
Mat4 	Mat4::operator+(const Mat4 &m) const {
	return Mat4(this->v[Mat4::rc::_11] + m.get(Mat4::rc::_11),
	            this->v[Mat4::rc::_12] + m.get(Mat4::rc::_12),
				this->v[Mat4::rc::_13] + m.get(Mat4::rc::_13),
				this->v[Mat4::rc::_14] + m.get(Mat4::rc::_14),
	            this->v[Mat4::rc::_21] + m.get(Mat4::rc::_21),
	            this->v[Mat4::rc::_22] + m.get(Mat4::rc::_22),
				this->v[Mat4::rc::_23] + m.get(Mat4::rc::_23),
				this->v[Mat4::rc::_24] + m.get(Mat4::rc::_24),
				this->v[Mat4::rc::_31] + m.get(Mat4::rc::_31),
	            this->v[Mat4::rc::_32] + m.get(Mat4::rc::_32),
				this->v[Mat4::rc::_33] + m.get(Mat4::rc::_33),
				this->v[Mat4::rc::_34] + m.get(Mat4::rc::_34),
				this->v[Mat4::rc::_41] + m.get(Mat4::rc::_41),
	            this->v[Mat4::rc::_42] + m.get(Mat4::rc::_42),
				this->v[Mat4::rc::_43] + m.get(Mat4::rc::_43),
				this->v[Mat4::rc::_44] + m.get(Mat4::rc::_44));
}

Mat4	Mat4::operator*(const Mat4 &m2) const {
	return Mat4(
		(this->v[Mat4::rc::_11] * m2.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_12] * m2.get(Mat4::rc::_21)) + 
		(this->v[Mat4::rc::_13] * m2.get(Mat4::rc::_31)) + (this->v[Mat4::rc::_14] * m2.get(Mat4::rc::_41)),
		(this->v[Mat4::rc::_11] * m2.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_12] * m2.get(Mat4::rc::_22)) + 
		(this->v[Mat4::rc::_13] * m2.get(Mat4::rc::_32)) + (this->v[Mat4::rc::_14] * m2.get(Mat4::rc::_42)),
		(this->v[Mat4::rc::_11] * m2.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_12] * m2.get(Mat4::rc::_23)) + 
		(this->v[Mat4::rc::_13] * m2.get(Mat4::rc::_33)) + (this->v[Mat4::rc::_14] * m2.get(Mat4::rc::_43)),
		(this->v[Mat4::rc::_11] * m2.get(Mat4::rc::_14)) + (this->v[Mat4::rc::_12] * m2.get(Mat4::rc::_24)) + 
		(this->v[Mat4::rc::_13] * m2.get(Mat4::rc::_34)) + (this->v[Mat4::rc::_14] * m2.get(Mat4::rc::_44)),
		(this->v[Mat4::rc::_21] * m2.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_22] * m2.get(Mat4::rc::_21)) + 
		(this->v[Mat4::rc::_23] * m2.get(Mat4::rc::_31)) + (this->v[Mat4::rc::_24] * m2.get(Mat4::rc::_41)),
		(this->v[Mat4::rc::_21] * m2.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_22] * m2.get(Mat4::rc::_22)) + 
		(this->v[Mat4::rc::_23] * m2.get(Mat4::rc::_32)) + (this->v[Mat4::rc::_24] * m2.get(Mat4::rc::_42)),
		(this->v[Mat4::rc::_21] * m2.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_22] * m2.get(Mat4::rc::_23)) + 
		(this->v[Mat4::rc::_23] * m2.get(Mat4::rc::_33)) + (this->v[Mat4::rc::_24] * m2.get(Mat4::rc::_43)),
		(this->v[Mat4::rc::_21] * m2.get(Mat4::rc::_14)) + (this->v[Mat4::rc::_22] * m2.get(Mat4::rc::_24)) + 
		(this->v[Mat4::rc::_23] * m2.get(Mat4::rc::_34)) + (this->v[Mat4::rc::_24] * m2.get(Mat4::rc::_44)),
		(this->v[Mat4::rc::_31] * m2.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_32] * m2.get(Mat4::rc::_21)) + 
		(this->v[Mat4::rc::_33] * m2.get(Mat4::rc::_31)) + (this->v[Mat4::rc::_34] * m2.get(Mat4::rc::_41)),
		(this->v[Mat4::rc::_31] * m2.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_32] * m2.get(Mat4::rc::_22)) + 
		(this->v[Mat4::rc::_33] * m2.get(Mat4::rc::_32)) + (this->v[Mat4::rc::_34] * m2.get(Mat4::rc::_42)),
		(this->v[Mat4::rc::_31] * m2.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_32] * m2.get(Mat4::rc::_23)) + 
		(this->v[Mat4::rc::_33] * m2.get(Mat4::rc::_33)) + (this->v[Mat4::rc::_34] * m2.get(Mat4::rc::_43)),
		(this->v[Mat4::rc::_31] * m2.get(Mat4::rc::_14)) + (this->v[Mat4::rc::_32] * m2.get(Mat4::rc::_24)) + 
		(this->v[Mat4::rc::_33] * m2.get(Mat4::rc::_34)) + (this->v[Mat4::rc::_34] * m2.get(Mat4::rc::_44)),
		(this->v[Mat4::rc::_41] * m2.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_42] * m2.get(Mat4::rc::_21)) + 
		(this->v[Mat4::rc::_43] * m2.get(Mat4::rc::_31)) + (this->v[Mat4::rc::_44] * m2.get(Mat4::rc::_41)),
		(this->v[Mat4::rc::_41] * m2.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_42] * m2.get(Mat4::rc::_22)) + 
		(this->v[Mat4::rc::_43] * m2.get(Mat4::rc::_32)) + (this->v[Mat4::rc::_44] * m2.get(Mat4::rc::_42)),
		(this->v[Mat4::rc::_41] * m2.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_42] * m2.get(Mat4::rc::_23)) + 
		(this->v[Mat4::rc::_43] * m2.get(Mat4::rc::_33)) + (this->v[Mat4::rc::_44] * m2.get(Mat4::rc::_43)),
		(this->v[Mat4::rc::_41] * m2.get(Mat4::rc::_14)) + (this->v[Mat4::rc::_42] * m2.get(Mat4::rc::_24)) + 
		(this->v[Mat4::rc::_43] * m2.get(Mat4::rc::_34)) + (this->v[Mat4::rc::_44] * m2.get(Mat4::rc::_44))
	);
	/*
	return Mat4(
		(this->v[Mat4::rc::_11] * m.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_12] * m.get(Mat4::rc::_21)) + (this->v[Mat4::rc::_13] * m.get(Mat4::rc::_31)),
		(this->v[Mat4::rc::_11] * m.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_12] * m.get(Mat4::rc::_22)) + (this->v[Mat4::rc::_13] * m.get(Mat4::rc::_32)),
		(this->v[Mat4::rc::_11] * m.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_12] * m.get(Mat4::rc::_23)) + (this->v[Mat4::rc::_13] * m.get(Mat4::rc::_33)),
		(this->v[Mat4::rc::_21] * m.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_22] * m.get(Mat4::rc::_21)) + (this->v[Mat4::rc::_23] * m.get(Mat4::rc::_31)),
		(this->v[Mat4::rc::_21] * m.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_22] * m.get(Mat4::rc::_22)) + (this->v[Mat4::rc::_23] * m.get(Mat4::rc::_32)),
		(this->v[Mat4::rc::_21] * m.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_22] * m.get(Mat4::rc::_23)) + (this->v[Mat4::rc::_23] * m.get(Mat4::rc::_33)),
		(this->v[Mat4::rc::_31] * m.get(Mat4::rc::_11)) + (this->v[Mat4::rc::_32] * m.get(Mat4::rc::_21)) + (this->v[Mat4::rc::_33] * m.get(Mat4::rc::_31)),
		(this->v[Mat4::rc::_31] * m.get(Mat4::rc::_12)) + (this->v[Mat4::rc::_32] * m.get(Mat4::rc::_22)) + (this->v[Mat4::rc::_33] * m.get(Mat4::rc::_32)),
		(this->v[Mat4::rc::_31] * m.get(Mat4::rc::_13)) + (this->v[Mat4::rc::_32] * m.get(Mat4::rc::_23)) + (this->v[Mat4::rc::_33] * m.get(Mat4::rc::_33)));
	*/
}

Mat4&	Mat4::operator=(const Mat4 &m) {
	this->v[Mat4::rc::_11] = m.get(Mat4::rc::_11);
	this->v[Mat4::rc::_12] = m.get(Mat4::rc::_12);
	this->v[Mat4::rc::_13] = m.get(Mat4::rc::_13);
	this->v[Mat4::rc::_14] = m.get(Mat4::rc::_14);
	this->v[Mat4::rc::_21] = m.get(Mat4::rc::_21);
	this->v[Mat4::rc::_22] = m.get(Mat4::rc::_22);
	this->v[Mat4::rc::_23] = m.get(Mat4::rc::_23);
	this->v[Mat4::rc::_24] = m.get(Mat4::rc::_24);
	this->v[Mat4::rc::_31] = m.get(Mat4::rc::_31);
	this->v[Mat4::rc::_32] = m.get(Mat4::rc::_32);
	this->v[Mat4::rc::_33] = m.get(Mat4::rc::_33);
	this->v[Mat4::rc::_34] = m.get(Mat4::rc::_34);
	this->v[Mat4::rc::_41] = m.get(Mat4::rc::_41);
	this->v[Mat4::rc::_42] = m.get(Mat4::rc::_42);
	this->v[Mat4::rc::_43] = m.get(Mat4::rc::_43);
	this->v[Mat4::rc::_44] = m.get(Mat4::rc::_44);
	return *this;
}
Mat4&	Mat4::operator+=(const Mat4 &m) {
	this->v[Mat4::rc::_11] += m.get(Mat4::rc::_11);
	this->v[Mat4::rc::_12] += m.get(Mat4::rc::_12);
	this->v[Mat4::rc::_13] += m.get(Mat4::rc::_13);
	this->v[Mat4::rc::_14] += m.get(Mat4::rc::_14);
	this->v[Mat4::rc::_21] += m.get(Mat4::rc::_21);
	this->v[Mat4::rc::_22] += m.get(Mat4::rc::_22);
	this->v[Mat4::rc::_23] += m.get(Mat4::rc::_23);
	this->v[Mat4::rc::_24] += m.get(Mat4::rc::_24);
	this->v[Mat4::rc::_31] += m.get(Mat4::rc::_31);
	this->v[Mat4::rc::_32] += m.get(Mat4::rc::_32);
	this->v[Mat4::rc::_33] += m.get(Mat4::rc::_33);
	this->v[Mat4::rc::_34] += m.get(Mat4::rc::_34);
	this->v[Mat4::rc::_41] += m.get(Mat4::rc::_41);
	this->v[Mat4::rc::_42] += m.get(Mat4::rc::_42);
	this->v[Mat4::rc::_43] += m.get(Mat4::rc::_43);
	this->v[Mat4::rc::_44] += m.get(Mat4::rc::_44);
	return *this;
}

Mat4&	Mat4::operator-=(const Mat4 &m) {
	this->v[Mat4::rc::_11] -= m.get(Mat4::rc::_11);
	this->v[Mat4::rc::_12] -= m.get(Mat4::rc::_12);
	this->v[Mat4::rc::_13] -= m.get(Mat4::rc::_13);
	this->v[Mat4::rc::_14] -= m.get(Mat4::rc::_14);
	this->v[Mat4::rc::_21] -= m.get(Mat4::rc::_21);
	this->v[Mat4::rc::_22] -= m.get(Mat4::rc::_22);
	this->v[Mat4::rc::_23] -= m.get(Mat4::rc::_23);
	this->v[Mat4::rc::_24] -= m.get(Mat4::rc::_24);
	this->v[Mat4::rc::_31] -= m.get(Mat4::rc::_31);
	this->v[Mat4::rc::_32] -= m.get(Mat4::rc::_32);
	this->v[Mat4::rc::_33] -= m.get(Mat4::rc::_33);
	this->v[Mat4::rc::_34] -= m.get(Mat4::rc::_34);
	this->v[Mat4::rc::_41] -= m.get(Mat4::rc::_41);
	this->v[Mat4::rc::_42] -= m.get(Mat4::rc::_42);
	this->v[Mat4::rc::_43] -= m.get(Mat4::rc::_43);
	this->v[Mat4::rc::_44] -= m.get(Mat4::rc::_44);
	return *this;
}
Mat4&	Mat4::operator*=(const Mat4 &m) {
	Mat4 temp = *this * m;
	*this = temp;
	return *this;
}

Mat4 	Mat4::operator-(const float &m) const {
	return Mat4(this->v[Mat4::rc::_11] - m,
				this->v[Mat4::rc::_12] - m,
				this->v[Mat4::rc::_13] - m,
				this->v[Mat4::rc::_14] - m,
				this->v[Mat4::rc::_21] - m,
				this->v[Mat4::rc::_22] - m,
				this->v[Mat4::rc::_23] - m,
				this->v[Mat4::rc::_24] - m,
				this->v[Mat4::rc::_31] - m,
				this->v[Mat4::rc::_32] - m,
				this->v[Mat4::rc::_33] - m,
				this->v[Mat4::rc::_34] - m,
				this->v[Mat4::rc::_41] - m,
				this->v[Mat4::rc::_42] - m,
				this->v[Mat4::rc::_43] - m,
				this->v[Mat4::rc::_44] - m);
}
Mat4 	Mat4::operator+(const float &m) const {
	return Mat4(this->v[Mat4::rc::_11] + m,
				this->v[Mat4::rc::_12] + m,
				this->v[Mat4::rc::_13] + m,
				this->v[Mat4::rc::_14] + m,
				this->v[Mat4::rc::_21] + m,
				this->v[Mat4::rc::_22] + m,
				this->v[Mat4::rc::_23] + m,
				this->v[Mat4::rc::_24] + m,
				this->v[Mat4::rc::_31] + m,
				this->v[Mat4::rc::_32] + m,
				this->v[Mat4::rc::_33] + m,
				this->v[Mat4::rc::_34] + m,
				this->v[Mat4::rc::_41] + m,
				this->v[Mat4::rc::_42] + m,
				this->v[Mat4::rc::_43] + m,
				this->v[Mat4::rc::_44] + m);
}
Mat4 	Mat4::operator*(const float &m) const {
	return Mat4(this->v[Mat4::rc::_11] * m,
				this->v[Mat4::rc::_12] * m,
				this->v[Mat4::rc::_13] * m,
				this->v[Mat4::rc::_14] * m,
				this->v[Mat4::rc::_21] * m,
				this->v[Mat4::rc::_22] * m,
				this->v[Mat4::rc::_23] * m,
				this->v[Mat4::rc::_24] * m,
				this->v[Mat4::rc::_31] * m,
				this->v[Mat4::rc::_32] * m,
				this->v[Mat4::rc::_33] * m,
				this->v[Mat4::rc::_34] * m,
				this->v[Mat4::rc::_41] * m,
				this->v[Mat4::rc::_42] * m,
				this->v[Mat4::rc::_43] * m,
				this->v[Mat4::rc::_44] * m);
}
Mat4& 	Mat4::operator=(const float &m) {
	this->v[Mat4::rc::_11] = m;
	this->v[Mat4::rc::_12] = m;
	this->v[Mat4::rc::_13] = m;
	this->v[Mat4::rc::_14] = m;
	this->v[Mat4::rc::_21] = m;
	this->v[Mat4::rc::_22] = m;
	this->v[Mat4::rc::_23] = m;
	this->v[Mat4::rc::_24] = m;
	this->v[Mat4::rc::_31] = m;
	this->v[Mat4::rc::_32] = m;
	this->v[Mat4::rc::_33] = m;
	this->v[Mat4::rc::_34] = m;
	this->v[Mat4::rc::_41] = m;
	this->v[Mat4::rc::_42] = m;
	this->v[Mat4::rc::_43] = m;
	this->v[Mat4::rc::_44] = m;
	return *this;
}
Mat4& 	Mat4::operator+=(const float &m) {
	this->v[Mat4::rc::_11] += m;
	this->v[Mat4::rc::_12] += m;
	this->v[Mat4::rc::_13] += m;
	this->v[Mat4::rc::_14] += m;
	this->v[Mat4::rc::_21] += m;
	this->v[Mat4::rc::_22] += m;
	this->v[Mat4::rc::_23] += m;
	this->v[Mat4::rc::_24] += m;
	this->v[Mat4::rc::_31] += m;
	this->v[Mat4::rc::_32] += m;
	this->v[Mat4::rc::_33] += m;
	this->v[Mat4::rc::_34] += m;
	this->v[Mat4::rc::_41] += m;
	this->v[Mat4::rc::_42] += m;
	this->v[Mat4::rc::_43] += m;
	this->v[Mat4::rc::_44] += m;
	return *this;
}
Mat4& 	Mat4::operator-=(const float &m) {
	this->v[Mat4::rc::_11] -= m;
	this->v[Mat4::rc::_12] -= m;
	this->v[Mat4::rc::_13] -= m;
	this->v[Mat4::rc::_14] -= m;
	this->v[Mat4::rc::_21] -= m;
	this->v[Mat4::rc::_22] -= m;
	this->v[Mat4::rc::_23] -= m;
	this->v[Mat4::rc::_24] -= m;
	this->v[Mat4::rc::_31] -= m;
	this->v[Mat4::rc::_32] -= m;
	this->v[Mat4::rc::_33] -= m;
	this->v[Mat4::rc::_34] -= m;
	this->v[Mat4::rc::_41] -= m;
	this->v[Mat4::rc::_42] -= m;
	this->v[Mat4::rc::_43] -= m;
	this->v[Mat4::rc::_44] -= m;
	return *this;
}
Mat4& 	Mat4::operator*=(const float &m) {
	this->v[Mat4::rc::_11] *= m;
	this->v[Mat4::rc::_12] *= m;
	this->v[Mat4::rc::_13] *= m;
	this->v[Mat4::rc::_14] *= m;
	this->v[Mat4::rc::_21] *= m;
	this->v[Mat4::rc::_22] *= m;
	this->v[Mat4::rc::_23] *= m;
	this->v[Mat4::rc::_24] *= m;
	this->v[Mat4::rc::_31] *= m;
	this->v[Mat4::rc::_32] *= m;
	this->v[Mat4::rc::_33] *= m;
	this->v[Mat4::rc::_34] *= m;
	this->v[Mat4::rc::_41] *= m;
	this->v[Mat4::rc::_42] *= m;
	this->v[Mat4::rc::_43] *= m;
	this->v[Mat4::rc::_44] *= m;
	return *this;
}

float Mat4::det() {
	float determinant = 0.f;
	Mat3 temp = { this->v[Mat4::rc::_22], this->v[Mat4::rc::_23], this->v[Mat4::rc::_24], 
				  this->v[Mat4::rc::_32], this->v[Mat4::rc::_33], this->v[Mat4::rc::_34], 
				  this->v[Mat4::rc::_42], this->v[Mat4::rc::_43], this->v[Mat4::rc::_44] };
	determinant += (this->v[Mat4::rc::_11] * temp.det());
	temp = { this->v[Mat4::rc::_21], this->v[Mat4::rc::_23], this->v[Mat4::rc::_24], 
			 this->v[Mat4::rc::_31], this->v[Mat4::rc::_33], this->v[Mat4::rc::_34], 
			 this->v[Mat4::rc::_41], this->v[Mat4::rc::_43], this->v[Mat4::rc::_44] };
	determinant += (this->v[Mat4::rc::_12] * temp.det());
	temp = { this->v[Mat4::rc::_21], this->v[Mat4::rc::_22], this->v[Mat4::rc::_24], 
			 this->v[Mat4::rc::_31], this->v[Mat4::rc::_32], this->v[Mat4::rc::_34], 
			 this->v[Mat4::rc::_41], this->v[Mat4::rc::_42], this->v[Mat4::rc::_44] };
	determinant += (this->v[Mat4::rc::_13] * temp.det());
	temp = { this->v[Mat4::rc::_21], this->v[Mat4::rc::_22], this->v[Mat4::rc::_23], 
			 this->v[Mat4::rc::_31], this->v[Mat4::rc::_32], this->v[Mat4::rc::_33], 
			 this->v[Mat4::rc::_41], this->v[Mat4::rc::_42], this->v[Mat4::rc::_43] };
	determinant += (this->v[Mat4::rc::_14] * temp.det());
	return determinant;

}
void Mat4::transponse() {
	float temp = this->v[Mat4::rc::_21];
	this->v[Mat4::rc::_21] = this->v[Mat4::rc::_12];
	this->v[Mat4::rc::_12] = temp;
	temp = this->v[Mat4::rc::_31];
	this->v[Mat4::rc::_31] = this->v[Mat4::rc::_13];
	this->v[Mat4::rc::_13] = temp;
	temp = this->v[Mat4::rc::_32];
	this->v[Mat4::rc::_32] = this->v[Mat4::rc::_23];
	this->v[Mat4::rc::_23] = temp;
	temp = this->v[Mat4::rc::_41];
	this->v[Mat4::rc::_41] = this->v[Mat4::rc::_14];
	this->v[Mat4::rc::_14] = temp;
	temp = this->v[Mat4::rc::_42];
	this->v[Mat4::rc::_42] = this->v[Mat4::rc::_24];
	this->v[Mat4::rc::_24] = temp;
	temp = this->v[Mat4::rc::_43];
	this->v[Mat4::rc::_43] = this->v[Mat4::rc::_34];
	this->v[Mat4::rc::_34] = temp;
}

void Mat4::inverse() {	
	float factor = 1.f/this->det();
	Mat3 temp;
	Mat4 that = *this;
	temp = { that.get(Mat4::rc::_22), that.get(Mat4::rc::_23), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_32), that.get(Mat4::rc::_33), that.get(Mat4::rc::_34), 
			 that.get(Mat4::rc::_42), that.get(Mat4::rc::_43), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_11] = temp.det();
	temp = { that.get(Mat4::rc::_21), that.get(Mat4::rc::_23), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_33), that.get(Mat4::rc::_34), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_43), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_12] = -temp.det();
	temp = { that.get(Mat4::rc::_21), that.get(Mat4::rc::_22), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_32), that.get(Mat4::rc::_34), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_42), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_13] = temp.det();
	temp = { that.get(Mat4::rc::_21), that.get(Mat4::rc::_22), that.get(Mat4::rc::_23), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_32), that.get(Mat4::rc::_33), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_42), that.get(Mat4::rc::_43)};
	this->v[Mat4::rc::_14] = -temp.det();
	
	temp = { that.get(Mat4::rc::_12), that.get(Mat4::rc::_13), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_32), that.get(Mat4::rc::_33), that.get(Mat4::rc::_34), 
			 that.get(Mat4::rc::_42), that.get(Mat4::rc::_43), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_21] = -temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_13), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_33), that.get(Mat4::rc::_34), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_43), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_22] = temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_12), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_32), that.get(Mat4::rc::_34), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_42), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_23] = -temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_12), that.get(Mat4::rc::_13), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_32), that.get(Mat4::rc::_33), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_42), that.get(Mat4::rc::_43)};
	this->v[Mat4::rc::_24] = temp.det();

	temp = { that.get(Mat4::rc::_12), that.get(Mat4::rc::_13), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_22), that.get(Mat4::rc::_23), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_42), that.get(Mat4::rc::_43), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_31] = temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_13), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_21), that.get(Mat4::rc::_23), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_43), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_32] = -temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_12), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_21), that.get(Mat4::rc::_22), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_42), that.get(Mat4::rc::_44)};
	this->v[Mat4::rc::_33] = temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_12), that.get(Mat4::rc::_13), 
			 that.get(Mat4::rc::_21), that.get(Mat4::rc::_22), that.get(Mat4::rc::_23), 
			 that.get(Mat4::rc::_41), that.get(Mat4::rc::_42), that.get(Mat4::rc::_43)};
	this->v[Mat4::rc::_34] = -temp.det();
	
	temp = { that.get(Mat4::rc::_12), that.get(Mat4::rc::_13), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_22), that.get(Mat4::rc::_23), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_32), that.get(Mat4::rc::_33), that.get(Mat4::rc::_34)};
	this->v[Mat4::rc::_41] = -temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_13), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_21), that.get(Mat4::rc::_23), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_33), that.get(Mat4::rc::_34)};
	this->v[Mat4::rc::_42] = temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_12), that.get(Mat4::rc::_14), 
			 that.get(Mat4::rc::_21), that.get(Mat4::rc::_22), that.get(Mat4::rc::_24), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_32), that.get(Mat4::rc::_34)};
	this->v[Mat4::rc::_43] = -temp.det();
	temp = { that.get(Mat4::rc::_11), that.get(Mat4::rc::_12), that.get(Mat4::rc::_13), 
		     that.get(Mat4::rc::_21), that.get(Mat4::rc::_22), that.get(Mat4::rc::_23), 
			 that.get(Mat4::rc::_31), that.get(Mat4::rc::_32), that.get(Mat4::rc::_33)};
	this->v[Mat4::rc::_44] = temp.det();
	this->transponse();
	*this *= factor;
}
