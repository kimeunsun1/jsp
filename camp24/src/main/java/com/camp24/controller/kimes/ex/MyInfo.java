package com.camp24.controller.kimes.ex;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp24.controller.kimes.*;
import com.camp24.dao.kimes.*;
import com.camp24.vo.*;

public class MyInfo implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 검사
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		
		String view = "/ex/memberInfo";
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/ex/login.cmp";
			return view;
		}
		
		// 로그인 되어있는 경우
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getIdInfo(sid);
		
		// mVO에 저장
		req.setAttribute("DATA", mVO);
		
		// 결과 반환
		return view;
	}

}
