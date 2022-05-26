package com.camp24.controller.kimes.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.kimes.*;

public class LoginForm implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/ex/login";
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 경우
			req.setAttribute("isRedirect", true);
			view = "/camp24/main.cmp";
		}
		
		return view;
	}

}
