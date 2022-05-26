package com.camp24.controller.kimes;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	김은선
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 									담당자 ] 김은선
 *
 */
	
public class CmpMain implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String view = "/main";
		return view;
	}

}
