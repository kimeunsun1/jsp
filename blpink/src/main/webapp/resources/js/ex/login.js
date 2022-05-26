$(document).ready(function(){
	$('#lbtn').click(function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		if(!sid){
			$('#id').focus();
			return;
		}
		if(!spw){
			$('#pw').focus();
			return;
		}
		
		$('#frm').attr('action', '/camp24/ex/loginProc.cmp');
		$('#frm').submit();
	});
	
	// 홈버튼 클릭이벤트
	$('#hbtn').click(function(){
		$(location).attr('href', '/camp24/main.cmp');
	});
});