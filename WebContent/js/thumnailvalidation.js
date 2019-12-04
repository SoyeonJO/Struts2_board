/**
 * var value = "가나다";
 * value.contains('나');
 * value.length();
 * 
 * "a001".validationID()
 * 정규식 패턴 작성 : http://ryanswanson.com/regexp/#start
 */
String.prototype.validationTITLE = function() {
	return /^[a-zA-Z0-9가-힣]+$/.test(this);
};

String.prototype.validationNICKNAME = function() {
	return /^[a-zA-Z가-힣]{3,5}$/.test(this);
};

String.prototype.validationPWD = function() {
	return /^[a-z0-9]{4,8}$/.test(this);
};

// \w == [0-9a-zA-Z_]
// +  == 1번 이상 반복(반복횟수 무제한)
// .  == 키보드로 입력 가능한 문자 한개
// \  == 이스케이프 문자
String.prototype.validationMAIL = function() {
	return /^\w+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};


