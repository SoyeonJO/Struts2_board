/**
 * var value = "가나다";
 * value.contains('나');
 * value.length();
 * 
 * "a001".validationID()
 * 정규식 패턴 작성 : http://ryanswanson.com/regexp/#start
 */
String.prototype.validationID = function() {
	return /^[a-z][0-9]{3}$/.test(this);
};

String.prototype.validationPWD = function() {
	return /^[a-z0-9]{8,20}$/.test(this);
};

String.prototype.validationNM = function() {
	return /^[가-힣A-Za-z]{2,10}$/.test(this);
};

String.prototype.validationBIR = function() {
	return /^(19[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/.test(this);
};

String.prototype.validationHTEL = function() {
	return /^0\d{1,2}-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationCTEL = function() {
	return /^0\d{1,2}-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationHP = function() {
	return /^01(0|1|6|7|8|9)-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationDONG = function() {
	return /^[가-힣]{2,6}$/.test(this);
};

String.prototype.validationBNAME = function() {
	return /^[가-힣A-Za-z]{2,10}$/.test(this);
};

String.prototype.validationPRODINFO = function() {
	return /^[가-힣A-Za-z!@#$%^&*?><]{2,50}$/.test(this);
};

int.prototype.validationPRODCOST = function() {
	return /^[0-9]{1,10}$/.test(this);
};

// \w == [0-9a-zA-Z_]
// +  == 1번 이상 반복(반복횟수 무제한)
// .  == 키보드로 입력 가능한 문자 한개
// \  == 이스케이프 문자
String.prototype.validationMAIL = function() {
	return /^\w+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};

String.prototype.validationREGNO = function() {
	// '1 1 1 1 1 1 - 1 1 1 1 1 1                      8  
	//  * * * * * * - * * * * * *
	//  2+3+4+5+6+7 + 8+9+2+3+4+5  = 연산결과       매직넘버
	// (11 - (연산결과 % 11)) % 10 = 최종값
	// if(최종값 == 매직넘버) 유효한 주민등록번호
    var moto = this.replace('-', '');
    var magicNumber = moto.substr(12,1);
    var sequenceValue = '234567892345';
    var sum = 0;
    
    for(var i = 0; i< 12; i++) {
    	sum+= moto.charAt(i) * sequenceValue.charAt(i);
    }
    
    var finalValue = (11-(sum%11))%10;
    
    if(finalValue == parseInt(magicNumber)) {
    	return true;
    }else {
    	return false;
    }
};


