<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BlackPink 방명록</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/user.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/whistle/resources/js/whistle/gboardWrite.js"></script>
<style type="text/css">
	.w3-button {
		padding: 1px 16px;
	}
	.box120 {
		width: 135px;
	}
</style>
<%--

 --%>
</head>
<body>
	<div class="w3-content mxw650 w3-margin-top">
		<!-- 페이지 헤더 -->
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-pink w3-center w3-padding mg0">BlackPink 방명록 글쓰기</h1>
			<nav class="w3-bar w3-yellow">
				<div class="w3-col w150 w3-button w3-small w3-green" id="hbtn">home</div>
				<div class="w3-col w150 w3-button w3-small w3-red w3-right" id="obtn">logout</div>
			</nav>
		</header>
		
		<form method="POST" action="/whistle/guestBoard/gBordWriteProc.blp" name="frm" id="frm"
			class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding mgb20">
			<input type="hidden" name="mno" value="${DATA.mno}">
			<div class="w3-col box120 pdAll10 w3-border-right w3-border-deep-orange">
				<img src="/whistle/resources/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
			</div>
			<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom w3-border-deep-orange">
					<span class="mgb10 ft10"><b>${SID}</b></span>
				<!-- 	<span class="w3-button w3-rigth w3-red w3-hover-orange mgb10 ft10" id="wpbtn">등록</span> -->
				</div>
				<div class="w3-col w3-margin-top">
					<testarea name="body" id="body"
						class="w3-col w3-padding ft12 w3-border-orange" style="resize: none; height: 100%;"></testarea>
				</div>
			</div>
			<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
		</form>
		<div class="w3-col w3-card-4">
			<div class="w3-third w3-button w3-green w3-hover-lime" id="lbtn">list</div>
			<div class="w3-third w3-button w3-amber w3-hover-yellow" id="rbtn">reset</div>
			<div class="w3-third w3-button w3-deep-orange w3-hover-yellow" id="wbtn">글등록</div>
		</div>
		<!-- 페이지 본문 -->
<c:forEach var="data" items="${LIST}">
		<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
			<div class="w3-col box120 pdAll10 w3-border-right">
				<img src="/whistle/resources/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
			</div>
			<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom">
					<span class="mgb10 ft10"><b>${data.id}</b></span>
					<span class="w3-right mgb10 ft10"><small>${data.sdate}</small></span>
				</div>
				<div class="w3-col w3-margin-top">
					<span class="w3-col w3-padding ft12">${data.body}</span>
				</div>
			</div>
		</div>
</c:forEach>
	
	<!-- 데이터 전송용 form 태그 -->
	<form method="POST" action="/whistle/guestBoard/gBoardList.blp" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
	</form>
</body>
</html>