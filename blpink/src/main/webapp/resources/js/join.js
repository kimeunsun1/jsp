var contentFull = true;
$(document).ready(function(){
	$(document.frm.gen).change(function(){
		var sgen = $(this).val();
		$('#avtfr').stop().slideUp(500, function(){	
			if(sgen == 'M'){
				$('#favt').css('display', 'none');
				$('#mavt').css('display', 'block');
				$('#avtfr').stop().slideDown(500);
			} else{
				$('#mavt').css('display', 'none');
				$('#favt').css('display', 'block');
				$('#avtfr').stop().slideDown(500);			
			}
		});
	});		
	// 아이디체크버튼 클릭이벤트
	$('#idck').click(function(){
		// 할일
		// 입력한 아이디 정보 가져오기
		var sid = $('#id').val();
		
		if(!sid){
			// 입력 내용이 없는 경우
			$('#id').focus();
			alert('* 아이디를 입력하세요!');
			return;
		}
		// 사용가능 유무 판단
		$.ajax({
			url: '/camp24/idCheck.cmp',
			type: 'post',
			dataType: 'json',
			data: {
				id: sid
			},
			success: function(data){
				var result = data.result;
				$('#idmsg').removeClass('w3-text-green w3-text-red');
				
				// 아이디 우선 정규식 검사							
				var idRegExp =/^[a-zA-Z0-9]{4,10}$/;
				
				if(idRegExp.test($('#id').val())){
					/*$(".id.idRegExp").html("");*/
					// 뷰에 출력					
					if(result == 'OK'){
						// 입력된 아이디가 사용 가능한 경우
						$('#idmsg').html('* 사용 가능한 아이디입니다! *');
						$('#idmsg').addClass('w3-text-green');
						$('#idCheck').val('Y');
					} else {
						// 입력된 아이디가 사용 불가능한 경우
						$('#idmsg').html('* 사용 불가능한 아이디입니다! *');
						$('#idmsg').addClass('w3-text-red');
					}
				} else {
					alert("아이디는 4 ~ 10개의 영문 대소문자, 숫자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
					if(true){
						$('#idmsg').html('');
						$('#idmsg').css('display', 'none');
						$("#id").val("");  
						$("#id").focus(); 
					}
				}
				$('#idmsg').css('display', 'block');			
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
	});
	
	$('idmsg').css('display','none');
	$('#id').keyup(function(){
		var id = $('#id').val();
		$('#idCheck').val('N');
		$('#idmsg').css('display', 'none');
		/*if(id == ''){
			$('#idmsg').css('display', 'none');
		}*/
	});
	
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
			}
		}
	});
	
	$('repwmsg').css('display','none');
	$('#pw').keyup(function(){
		var id = $('#pw').val();
		
		if(id == ''){
			$('#repwmsg').css('display', 'none');
		}
	});
	
	$('#repw').keyup(function(){
		var id = $('#repw').val();
		
		if(id == ''){
			$('#repwmsg').css('display', 'none');
		}
	});
	
	$('#jbtn').click(function(){
		// 데이터 유효성 검사
		// 사용가능 유무 판단
		var name = $('#name').val();
		
		var gen = $('[name="gen"]:checked').val();
		var ano = $('[name="ano"]:checked').val();
		
		for(var i = 0 ; i < name.length ; i++ ){
			var txt = $(name).eq(i).val();
			if(!txt){
				alert('# 이름의 입력사항을 확인해주세요!');
				$(name).eq(i).focus();
				return;
			}
		}
		
		var idRegExp =/^[a-zA-Z0-9]{4,10}$/;
				
		if(idRegExp.test($('#id').val())){
			$(".id.idRegExp").html("");
		} else {
			alert("아이디는 4 ~ 10개의 영문 대소문자, 숫자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
			$("#id").val("");  
			$("#id").focus(); 
			return;
		}
		
		if($('#idCheck').val()!='Y'){
			alert("아이디 중복체크를 해주세요.");
			$('#idCheck').eq(0).focus();
			return false;
		}
		
		var pwdRegExp =/^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		/*var pwdRegExp =/^[0-9]{4}$/;*/
		if(pwdRegExp.test($('#pw').val())){
			$(".pw.pwdRegExp").html("");
		} else {
			alert("비밀 번호는 4 ~ 10개의 영문 대소문자, 숫자, 특수문자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
			$("#pw").val(""); 
			$("#pwck").val(""); 
			$("#pw").focus(); 
			return;
		}
		
		var mailRegExp =/^[a-zA-Z0-9]{4,10}@[a-zA-Z.]{5,50}$/;
		if(mailRegExp.test($('#mail').val())){
			$(".mail.pwdRegExp").html("");
		} else {
			alert("메일 아이디는 4 ~ 10개의 영문 대소문자, 숫자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
			$("#mail").val(""); 
			$("#mail").focus(); 
			return;
		}
		
		var telRegExp =/^01[0-9]{1}-[0-9]{3,4}-[0-9]{4}$/;
		if(telRegExp.test($('#tel').val())){
			$(".tel.pwdRegExp").html("");
		} else {
			alert("휴대전화번호는 01*-***-**** 또는 01*-****-**** 형태의 숫자로 생성해야 합니다. 형식에 맞게 입력해주세요"); 
			$("#tel").val(""); 
			$("#tel").focus(); 
			return;
		}
		
		if(!(gen && ano)){
			alert('# 성별과 아바타 입력사항을 확인해주세요!');
			return;
		}	
		$('#frm').attr('action', '/camp24/joinProc.cmp').submit();		
	});
	
});