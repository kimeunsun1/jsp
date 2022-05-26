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
				
				// 뷰에 출력
				if(result == 'OK'){
					// 입력된 아이디가 사용 가능한 경우
					$('#idmsg').html('* 사용 가능한 아이디입니다! *');
					$('#idmsg').addClass('w3-text-green');
				} else {
					// 입력된 아이디가 사용 불가능한 경우
					$('#idmsg').html('* 사용 불가능한 아이디입니다! *');
					$('#idmsg').addClass('w3-text-red');
				}
				$('#idmsg').css('display', 'block');
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
	});
	
	// 비밀번호 입력이벤트
	$('#pw').change(function(){
		// 할일
		// 입력된 데이터 가져오기.
		var pw = $(this).val();
		
		var pat = /^$/;
		
		if(pat.test(pw)){
			$('#pwmsg').html('# 비밀번호를 입력해주세요.');
			$('#pwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red');
		} else {
			$('#pwmsg').html('* 비밀번호 확인을 진행해주세요. *');
			$('#pwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
		}
		$('#pwmsg').css('display', 'block');
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
	
	$('#jbtn').click(function(){
		// 데이터 유효성 검사
		var id = $('#id').val();
		var pw = $('#pw').val();
		var name = $('#name').val();
		var mail = $('#mail').val();
		var tel = $('#tel').val();
		
		var gen = $('[name="gen"]:checked').val();
		var ano = $('[name="ano"]:checked').val();
		
		var el = $('#id, #pw, #name, #mail, #tel');
		
		for(var i = 0 ; i < el.length ; i++ ){
			var txt = $(el).eq(i).val();
			if(!txt){
				alert('# 필수 입력사항을 확인하세요!');
				$(el).eq(i).focus();
				return;
			}
		}
		if(!(gen && ano)){
			alert('# 필수 선택 사항을 확인하세요!');
			return;
		}			
		$('#frm').attr('action', '/camp24/joinProc.cmp').submit();		
	});
	
	// 리셋 버튼
	$('#rbtn').click(function(){
		$(location).attr('href', '/camp24/join.cmp');
	});
	
	// 홈 버튼
	$('#hbtn').click(function(){
		$(location).attr('href', '/camp24/main.cmp');
	});
});

