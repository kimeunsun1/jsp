package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardWriteProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/whistle/reboard/reboardList.blp";
		
		// 할일
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/whistle/member/login.blp";
			return view;
		}
		
		// 파라미터 꺼내고
		String sno = req.getParameter("mno");
		String spage = req.getParameter("nowPage");
		String body = req.getParameter("body");
		String supno = req.getParameter("upno");
		
		BoardVO bVO = new BoardVO();
		bVO.setMno(Integer.parseInt(sno));
		bVO.setBody(body);
		
		if(supno != null) {
			bVO.setUpno(Integer.parseInt(supno));
		}
		
		// 데이터베이스 작업하고
		ReboardDao rDao = new ReboardDao();
		int cnt = rDao.addReboard(bVO);
		
		req.setAttribute("NOWPAGE", spage);								// redirect.jsp 등에서 사용
		// 결과에 따라서 처리하고
		if(cnt == 0 && supno == null) {
			// 원글 등록 실패
			// view = "/whistle/reboard/reboardWrite.blp?nowPage=" + spage; ==> GET 방식을 채용한 이 경우 주소창에 nowPage를 입력해야 하는 번거러움이 있다
			
			// post 방식 - forward 처리...
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/whistle/reboard/reboardWrite.blp");	// redirect.jsp 등에서 사용
//			return "/reboard/redirect";
			view = "/reboard/redirect";
		} else if(cnt == 0 && supno != null) {
			// 댓글 등록 실패
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/whistle/reboard/reboardComment.blp");	// redirect.jsp 등에서 사용
			view = "/reboard/redirect";
			
		} else if(cnt == 1 && supno != null) {
			// 댓글 등록 성공
			req.setAttribute("isRedirect", false);
			req.setAttribute("VIEW", "/whistle/reboard/reboardList.blp");	// redirect.jsp 등에서 사용
			view = "/reboard/redirect";
			
		}
		return view;
	}

}
