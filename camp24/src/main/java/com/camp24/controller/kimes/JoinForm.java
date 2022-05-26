package com.camp24.controller.kimes;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp24.controller.kimes.*;
import com.camp24.dao.kimes.*;
import com.camp24.vo.*;

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
	
public class JoinForm implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/join";
		// 세션 검사
		HttpSession session = req.getSession();
		if(session.getAttribute("SID") != null) {
			// 로그인 한 경우
			req.setAttribute("isRedirect", true);
			// 요청주소 반환
			return "/camp24/main.cmp";
		}
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> list = mDao.getAvtList();
		
		// 데이터 정의
		req.setAttribute("LIST", list);
		
		// 결과 반환
		return view;
	}

}
