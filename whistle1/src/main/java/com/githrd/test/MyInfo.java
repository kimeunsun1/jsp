package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/test/myInfo.pink")
public class MyInfo extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 세션에 저장한 데이터 삭제
		session.removeAttribute("SID");
		
		// 로그인 페이지로 새로운 요청을 한다.
		resp.sendRedirect("/whistle1/test/MyInfo.jsp");
		/*
		 * // 로그인 여부 검사 // 1. 세션객체 꺼내오고 HttpSession session = req.getSession(); // 2.
		 * 세션에서 저장된 데이터가 있는지 꺼내본다. String sid = (String) session.getAttribute("SID");
		 * 
		 * // 3. 검사 if(sid != null) { // 이 경우는 이미 세션에 데이터가 채워져 있는 경우이고 // 그말은 이미 로그인 한
		 * 상태다. // 따라서 메인페이지(index)로 돌려보낸다. // 이 작업은 지금 요청에서 메인페이지로 보내는 요청을 다시 만드는
		 * 작업이된다. // 따라서 리다이렉트 하면 된다. resp.sendRedirect("/whistle1/test/"); } else {
		 * String view = "/WEB-INF/views/test/member/login.jsp"; RequestDispatcher rd =
		 * req.getRequestDispatcher(view); rd.forward(req, resp); }
		 */
		/*
		 * // 3. 결과를 클라이언트에게 전달 // 응답문서 작성 도구를 호출 
		 * PrintWriter pw = resp.getWriter();
		 * 
		 * pw.println("{"); pw.println("\"membernumber\": \"NO\"");
		 * pw.println("\"회원이름\": \"OK\""); pw.println("\"아이디\": \"OK\"");
		 * pw.println("\"메일\": \"OK\""); pw.println("\"전화번호\": \"OK\"");
		 * pw.println("\"가입일\": \"OK\""); pw.println("\"성별\": \"OK\"");
		 * pw.println("\"아바타이미지\": \"OK\""); pw.println("}");
		 */	
	}

}
