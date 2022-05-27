/**
 * /resources/js/main.js
 */
 $(document).ready(function(){
	// 회원가입버튼 클릭이벤트
	$('#jbtn').click(function(){
		$(location).attr('href','/camp24/join.cmp')
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/camp24/ex/login.cmp');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/camp24/ex/logout.cmp');
	});
	
	$('#ibtn').click(function(){
		$(location).attr('href', '/camp24/ex/myInfo.cmp');
	});
});