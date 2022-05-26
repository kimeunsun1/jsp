package com.camp24.controller.kimes.ex;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp24.controller.kimes.*;

public class Logout implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/camp24/main.cmp";
		req.setAttribute("isRedirect", true);
		
		req.getSession().removeAttribute("SID");
		return view;
	}

}
