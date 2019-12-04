/**
 * 
 */
String.prototype.validationNAME = function(){
	return  /^[a-zA-Z가-힣]{3,5}$/.test(this);
};
String.prototype.validationEMAIL = function(){
	return /^[a-zA-Z0-9_-]+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};
String.prototype.validationPASSWORD = function(){
	return  /^[a-z0-9]{4,8}$/.test(this);
};
String.prototype.validationTITLE = function(){
	return /^[a-zA-Z0-9가-힣]+$/.test(this);
};
String.prototype.validationCONTENT = function() {
	return /^[a-zA-Z0-9가-힣]+$/.test(this);
};






