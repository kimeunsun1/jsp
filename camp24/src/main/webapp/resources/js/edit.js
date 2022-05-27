$(document).ready(function(){
	// 비밀번호 입력이벤트
	$('#repw').keyup(function(){
		// 할일
		// 입력된 데이터 가져오기
		var pw = $('#pw').val();
		var repw = $(this).val();
		if(repw != null){
			if(pw != repw){
				$('#repwmsg').html('# 비밀번호가 일치하지 않습니다.');
				$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red')
				$('#repwmsg').css('display', 'block');
				return;
			} else {
				$('#repwmsg').html('* # 비밀번호가 일치합니다. *');
				$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
				$('#repwmsg').css('display', 'block');
				$('#pwCheck').val('Y');
			}
		}
	});
	
	$('repwmsg').css('display','none');
	$('#pw').keyup(function(){
		var pw = $('#pw').val();
		
		if(pw == ''){
			$('#repwmsg').css('display', 'none');
		}
	});
	
	$('#repw').keyup(function(){
		var repw = $('#repw').val();
		
		if(repw == ''){
			$('#repwmsg').css('display', 'none');
		}
	});

	// 수정버튼 클릭이벤트
	$('#ebtn').click(function(){
		// 받은 데이터 가져오기
		var tname = $('#tname').val();
		var tmail = $('#tmail').val();
		var ttel = $('#ttel').val();
		var tano = $('#tano').val();
		
		// 입력한 데이터 가져오기
		var name = $('#name').val();
		var pw = $('#pw').val();
		var mail = $('#mail').val();
		var tel = $('#tel').val();
		var ano = $('[name="ano"]:checked').val();
		
		if(tname == name){
			// 이름이 수정 안된경우
			$('#name').prop('disabled', true);
		} else{
			var name = $('#name').val();
			if(!name){
				alert('# 이름의 입력사항을 확인해주세요!');
				$('#name').focus();
				return;
			}
		}
		
		if(!pw){
			$('#pw').prop('disabled', true);
		} else {
			var pwdRegExp =/^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
			if(pwdRegExp.test($('#pw').val())){
				$(".pw.pwdRegExp").html("");
			} else {
				alert("비밀 번호는 8개 이상의 영문 대소문자, 숫자, 특수문자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
				$("#pw").val(""); 
				$("#repw").val(""); 
				$("#pw").focus(); 
				return;
			}
		}
		
		if($('#pw').val() != ''){
			if($('#pwCheck').val() != 'Y'){
				alert("비밀번호를 확인해주세요.");
				$("#repw").val("");
				$('#repw').eq(0).focus();
				return;
			}
		}
		
		
		if(tmail == mail){
			// 메일이 수정 안된경우
			$('#mail').prop('disabled', true);
		} else {
			var mailRegExp =/^[a-zA-Z0-9]{4,10}@[a-zA-Z.]{5,50}$/;
			if(mailRegExp.test($('#mail').val())){
				$(".mail.pwdRegExp").html("");
			} else {
				alert("메일 아이디는 4 ~ 10개의 영문 대소문자, 숫자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
				$("#mail").val(""); 
				$("#mail").focus(); 
				return;
			}
		}
		
		if(ttel == tel){
			$('#tel').prop('disabled', true);
		} else {
			var telRegExp =/^01[0-9]{1}-[0-9]{3,4}-[0-9]{4}$/;
			if(telRegExp.test($('#tel').val())){
				$(".tel.pwdRegExp").html("");
			} else {
				alert("휴대전화번호는 01*-***-**** 또는 01*-****-**** 형태의 숫자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
				$("#tel").val(""); 
				$("#tel").focus(); 
				return;
			}
		}
		
		if(tano == ano){
			$('[name="ano"]').prop('disabled', true);
		} else{
			if(!(ano)){
			alert('# 성별과 아바타 입력사항을 확인해주세요!');
			return;
			}
		}
		
		if((tname == name) && !pw && (tmail == mail) && (ttel == tel) && (tano == ano)){
			// 수정사항이 없는 경우
			$('#frm').attr('action', '/camp24/ex/myInfo.cmp');
			$('#frm').submit();
			return;
		}

		// 보낼 주소 설정하고
		$('#frm').attr('action', '/camp24/editProc.cmp');
		$('#frm').submit();
	});
});