/**
 * var value = "가나다";
 * value.contains('나');
 * value.length();
 * 
 * "a001".validationID()
 * 정규식 패턴 작성 : http://ryanswanson.com/regexp/#start
 */
	var memberForm = function() {
		
		// 비밀번호
		var psvalue = $('#mem_pass').val();
		var psckvalue = $('#mem_pass_confirm').val();
		pslen = psvalue.trim().length;
		psreg = /^[a-z0-9]{8,20}$/ ;
		if(pslen <= 0) {
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		if(psvalue != psckvalue) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		if(!(psreg.test(psvalue))) {
			alert("비밀번호 형식이 잘못되었습니다.");
			return false;
		}
		
		
		// 닉네임
		var nickvalue = $('#mem_nick').val();
		nicklen = nickvalue.trim().length;
		nickreg = /^[가-힣A-Za-z]{2,10}$/ ;
		if(nicklen <= 0) {
			alert("닉네임을 입력해주세요.");
			return false;
		}
		if(!(nickreg.test(nickvalue))) {
			alert("닉네임 형식이 잘못되었습니다.");
			return false;
		}
		
		
		// 이메일
		var mailvalue = $('#mem_mail').val();
		maillen = mailvalue.trim().length;
		mailreg = /^\w+@[a-z]+(\.[a-z]+){1,2}$/ ;
		if(maillen <= 0) {
			alert("이메일을 입력해주세요.");
			return false;
		}
		if(!(mailreg.test(mailvalue))) {
			alert("이메일 형식이 잘못되었습니다.");
			return false;
		}
		
		
		// 생년월일
		var birvalue = $('#mem_birth').val();
		birlen = birvalue.trim().length;
		birreg = /^(19[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/ ;
		if(birlen <= 0) {
			alert("생년월일을 입력해주세요.");
			return false;
		}
		if(!(birreg.test(birvalue))) {
			alert("생년월일의 형식이 잘못되었습니다.");
			return false;
		}
		
		
		// 전화번호
		var telvalue = $('#mem_tel').val();
		tellen = telvalue.trim().length;
		telreg = /^01(0|1|6|7|8|9)-\d{3,4}-\d{4}$/ ;
		if(tellen <= 0) {
			alert("전화번호를 입력해주세요.");
			return false;
		}
		if(!(telreg.test(telvalue))) {
			alert("전화번호 형식이 잘못되었습니다.");
			return false;
		}
		
		
		return true;
	}

