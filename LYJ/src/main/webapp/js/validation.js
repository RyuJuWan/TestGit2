// ID validation
String.prototype.validID = function(){
	return /^[a-zA-Z0-9]{1,25}$/.test(this);
}

// Password validation
String.prototype.validPass = function(){
	return /^[a-zA-Z0-9]{1,25}$/.test(this);
}

// NM(Name) validation
String.prototype.validNM = function(){
	return /^[가-힣]{2,5}$/.test(this);
}

// Mail validation
String.prototype.validMail = function(){
	return /^[0-9a-zA-Z]+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
}

// Day validation
String.prototype.validDay = function(){
	return /^\d{4}-\d{2}-\d{2}$/.test(this);
}
